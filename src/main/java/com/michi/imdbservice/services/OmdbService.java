package com.michi.imdbservice.services;

import com.michi.imdbservice.domain.Film;
import com.michi.imdbservice.domain.FilmDetailed;
import com.michi.imdbservice.domain.persistance.FilmDetailedRepository;
import com.michi.imdbservice.domain.persistance.FilmRepository;
import com.michi.imdbservice.domain.persistance.OmdbDetailedFilm;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class OmdbService {
    //example of omdb request
    //http://www.omdbapi.com/?s=blade+runner&apikey=e088609c

    private FilmDetailedRepository detailedRepository;
    private FilmRepository filmRepository;


    public OmdbService(FilmDetailedRepository detailedRepository, FilmRepository filmRepository) {
        this.detailedRepository = detailedRepository;
        this.filmRepository = filmRepository;
    }

    public List<Film> searchByNameShort(String title) throws OmdbConnectionException {
        title = title.replace(" ", "+");
        String url = "http://www.omdbapi.com/?s=" + title + "&apikey=e088609c";
        return Film.fromJsonToList(makeRequest(url));

    }

    public FilmDetailed searchByIDDetailed(String id) throws OmdbConnectionException {
        id = id.replace(" ", "+");
        Optional<FilmDetailed> fromCache = getFromCacheById(id);
        if (fromCache.isPresent()) {
            return fromCache.get();
        } else {
            String url = "http://www.omdbapi.com/?i=" + id + "&apikey=e088609c";
            String filmAsJson = makeRequest(url);
            FilmDetailed filmDetailed = OmdbDetailedFilm.fromJson(filmAsJson).toDetailedFilm();
            storeInCache(filmDetailed);
            return filmDetailed;
        }
    }

    private Optional<FilmDetailed> getFromCacheById(String id) {
        return detailedRepository.findById(id);
    }

    private void storeInCache(FilmDetailed film) {
        detailedRepository.save(film);
        filmRepository.save(new Film(film.title, film.type, film.imdbID, film.posterURL, film.year));
    }

    private String makeRequest(String requestUrl) throws OmdbConnectionException {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            if (responseCode != 200)
                throw new OmdbConnectionException("Error in response: " + response.toString());

            return response.toString();
        } catch (IOException e) {
            throw new OmdbConnectionException("Couldn't connect to Omdb server");
        }
    }


}


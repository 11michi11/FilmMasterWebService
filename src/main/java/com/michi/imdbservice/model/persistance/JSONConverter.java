package com.michi.imdbservice.model.persistance;

import com.michi.imdbservice.model.Film;
import com.michi.imdbservice.model.FilmDetailed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class JSONConverter {

    public static List<Film> convertFilms(String json) {
        var films = new LinkedList<Film>();

        String wantedPart = removeUnnecessary(json);
        //remove enclosing brackets
        wantedPart = wantedPart.substring(1, wantedPart.length() - 1);
        //splitting films in parts
        var splitedFilms = wantedPart.split(Pattern.quote("},{"));
        var filmsAsLines = new LinkedList<String[]>();
        //splitting films to attributes
        Arrays.asList(splitedFilms).forEach(a -> filmsAsLines.add(a.split(",")));
        var splitedLines = new LinkedList<String[]>();
        filmsAsLines.forEach(line -> splitedLines.add(convertLineFromArray(line)));
        //convert to films
        splitedLines.forEach(line -> films.add(createFilmFromLine(line)));

        return films;
    }

    private static String removeUnnecessary(String json) {
        var arr1 = json.split(Pattern.quote("["));
        var str1 = arr1[1];
        var arr2 = str1.split(Pattern.quote("]"));
        return arr2[0];
    }

    private static String[] convertLineFromArray(String[] array) {
        var result = new String[array.length];

        for (int i = 0; i < array.length; i++)
            result[i] = array[i].split("\":")[1];

        return result;
    }

    private static Film createFilmFromLine(String[] line) {
        //title, year, imbdID, type, poster - line order
        var title = line[0].substring(1, line[0].length()-1);
        var type = line[3].substring(1, line[3].length()-1);
        var imbdID = line[2].substring(1, line[2].length()-1);
        var posterURL = line[4].substring(1, line[4].length()-1);
        var year = line[1].substring(1, line[1].length()-1);
        try {
            return new Film(title, type, imbdID, posterURL, year);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new Film("WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT");
        }
    }

    public static FilmDetailed convertDetailedFilm(String json) {
        var attributes = json.substring(1, json.length() - 1).trim().split(Pattern.quote("\","));
        var attrValues = convertLineFromArray(attributes);

        try {
            var title = attrValues[0].substring(1);
            var realisedDate = attrValues[3].substring(1);
            var runtime = attrValues[4].substring(1);
            var director = attrValues[6].substring(1);
            var actors = attrValues[8].substring(1);
            var plot = attrValues[9].substring(1);
            var posterURL = attrValues[13].substring(1);
            var imdbRating = attrValues[18].substring(1);
            var imdbID = attrValues[20].substring(1);

            return new FilmDetailed(title, realisedDate, runtime, director, actors, plot, posterURL, imdbRating, imdbID);
        }catch (IndexOutOfBoundsException e){
            return new FilmDetailed("WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT", "WRONG FORMAT");
        }
    }

    private static String testJson = "{\"Search\":[{\"Title\":\"Iron Man\",\"Year\":\"2008\",\"imdbID\":\"tt0371746\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTczNTI2ODUwOF5BMl5BanBnXkFtZTcwMTU0NTIzMw@@._V1_SX300.jpg\"},{\"Title\":\"Iron Man 3\",\"Year\":\"2013\",\"imdbID\":\"tt1300854\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjE5MzcyNjk1M15BMl5BanBnXkFtZTcwMjQ4MjcxOQ@@._V1_SX300.jpg\"},{\"Title\":\"Man of Steel\",\"Year\":\"2013\",\"imdbID\":\"tt0770828\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTk5ODk1NDkxMF5BMl5BanBnXkFtZTcwNTA5OTY0OQ@@._V1_SX300.jpg\"},{\"Title\":\"Spider-Man\",\"Year\":\"2002\",\"imdbID\":\"tt0145487\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZDEyN2NhMjgtMjdhNi00MmNlLWE5YTgtZGE4MzNjMTRlMGEwXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_SX300.jpg\"},{\"Title\":\"Iron Man 2\",\"Year\":\"2010\",\"imdbID\":\"tt1228705\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTM0MDgwNjMyMl5BMl5BanBnXkFtZTcwNTg3NzAzMw@@._V1_SX300.jpg\"},{\"Title\":\"The Amazing Spider-Man\",\"Year\":\"2012\",\"imdbID\":\"tt0948470\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjMyOTM4MDMxNV5BMl5BanBnXkFtZTcwNjIyNzExOA@@._V1_SX300.jpg\"},{\"Title\":\"Spider-Man 2\",\"Year\":\"2004\",\"imdbID\":\"tt0316654\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMzY2ODk4NmUtOTVmNi00ZTdkLTlmOWYtMmE2OWVhNTU2OTVkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"},{\"Title\":\"Ant-Man\",\"Year\":\"2015\",\"imdbID\":\"tt0478970\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjM2NTQ5Mzc2M15BMl5BanBnXkFtZTgwNTcxMDI2NTE@._V1_SX300.jpg\"},{\"Title\":\"Spider-Man 3\",\"Year\":\"2007\",\"imdbID\":\"tt0413300\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BYTk3MDljOWQtNGI2My00OTEzLTlhYjQtOTQ4ODM2MzUwY2IwXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg\"},{\"Title\":\"Rain Man\",\"Year\":\"1988\",\"imdbID\":\"tt0095953\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMzVjNzI4NzYtMjE4NS00M2IzLWFkOWMtOTYwMWUzN2ZlNGVjL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"}],\"totalResults\":\"9804\",\"Response\":\"True\"}";
    private static String testJsonFullFilm2 = "{\"Title\":\"Iron Man 3\",\"Year\":\"2013\",\"Rated\":\"PG-13\",\"Released\":\"03 May 2013\",\"Runtime\":\"130 min\",\"Genre\":\"Action, Adventure, Sci-Fi\",\"Director\":\"Shane Black\",\"Writer\":\"Drew Pearce (screenplay by), Shane Black (screenplay by), Stan Lee (based on the Marvel comic book by), Don Heck (based on the Marvel comic book by), Larry Lieber (based on the Marvel comic book by), Jack Kirby (based on the Marvel comic book by), Warren Ellis (based on the \\\"Extremis\\\" mini-series written by), Adi Granov (based on the \\\"Extremis\\\" mini-series illustrated by)\",\"Actors\":\"Robert Downey Jr., Gwyneth Paltrow, Don Cheadle, Guy Pearce\",\"Plot\":\"When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.\",\"Language\":\"English\",\"Country\":\"China, USA\",\"Awards\":\"Nominated for 1 Oscar. Another 17 wins & 61 nominations.\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjE5MzcyNjk1M15BMl5BanBnXkFtZTcwMjQ4MjcxOQ@@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.2/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"80%\"},{\"Source\":\"Metacritic\",\"Value\":\"62/100\"}],\"Metascore\":\"62\",\"imdbRating\":\"7.2\",\"imdbVotes\":\"643,821\",\"imdbID\":\"tt1300854\",\"Type\":\"movie\",\"DVD\":\"24 Sep 2013\",\"BoxOffice\":\"&pound;408,992,272\",\"Production\":\"Walt Disney Pictures\",\"Website\":\"http://IronManMovie3.com\",\"Response\":\"True\"}";
    public static void main(String[] args) {
        System.out.println(JSONConverter.convertDetailedFilm(testJsonFullFilm2));
    }
}

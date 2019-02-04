package com.michi.imdbservice.services;

public class OmdbConnectionException extends RuntimeException{
    public OmdbConnectionException(String msg){
        super(msg);
    }
}

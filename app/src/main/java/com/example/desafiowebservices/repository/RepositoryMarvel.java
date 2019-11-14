package com.example.desafiowebservices.repository;

import com.example.desafiowebservices.model.Comic;

import io.reactivex.Single;

import static com.example.desafiowebservices.network.RetrofitService.getApiService;


public class RepositoryMarvel {

    public Single<Comic> getAllComicsRepository(
        String format,
        String formatType,
        boolean noVariants,
        String orderBy,
        String ts,
        String hash,
        String apikey
    ) {
        return getApiService().getComics(format,formatType,noVariants,orderBy,ts,hash, apikey);
    }
}

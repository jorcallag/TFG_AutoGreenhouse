package com.example.autogreenhouse_application.api;

import retrofit.RestAdapter;

public class Api {

    public static ApiInterface getClient() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://autogreenhouse.azurewebsites.net")
                .build();

        ApiInterface api = adapter.create(ApiInterface.class);
        return api;
    }
}

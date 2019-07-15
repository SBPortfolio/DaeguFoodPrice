package com.example.daegufoodprice.retrofit;

import com.example.daegufoodprice.model.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static RetrofitService service = null;

    private static void getRetrofitInstance() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Utils.SERVICE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
    }

    public static RetrofitService getApiService() {
        getRetrofitInstance();
        if(service == null){
            service = retrofit.create(RetrofitService.class);
        }
        return service;
    }
}

package com.moringaschool.yummlyapi.network;

import com.moringaschool.yummlyapi.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeClient {
    private static Retrofit retrofit=null;

    public static SpoonacularApi getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(Constants.SPOONACULAR_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(SpoonacularApi.class );
    }
}

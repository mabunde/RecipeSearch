package com.moringaschool.yummlyapi.network;

import com.moringaschool.yummlyapi.models.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {
    @GET("recipes/complexSearch")
    Call<RecipeResponse> getRecipeList(
            @Query("apiKey") String myAPIKey
            );
}

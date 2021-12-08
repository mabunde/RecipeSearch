package com.moringaschool.yummlyapi.network;

import com.moringaschool.yummlyapi.models.SpoonacularRecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {
    @GET("recipes/complexSearch")
    Call<SpoonacularRecipeSearchResponse> getSearchRecipes(
            @Query("apiKey") String myAPIKey
            );
}

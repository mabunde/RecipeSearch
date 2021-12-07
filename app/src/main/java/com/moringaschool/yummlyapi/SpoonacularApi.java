package com.moringaschool.yummlyapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {
    @GET("recipes/complexSearch")
    Call<SpoonacularRecipeSearchResponse> getSearchRecipes(
            @Query("apiKey") String myAPIKey
            );
}

package com.moringaschool.spoonacularapi.network;

import com.moringaschool.spoonacularapi.models.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {
    @GET("recipes/complexSearch/?addRecipeInformation=true")
    Call<RecipeResponse> getRecipeList(
            @Query("apiKey") String myAPIKey
            );
}

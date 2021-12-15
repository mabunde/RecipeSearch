package com.moringaschool.spoonacularapi.network;

import com.moringaschool.spoonacularapi.models.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {
    @GET("recipes/complexSearch?addRecipeInformation=true")
    Call<RecipeResponse> getRecipeList(
            @Query("apiKey") String myAPIKeyz,
            @Query("addRecipeInformation") boolean addRecipeInformation,
            @Query("query") String query
            );

//    @GET("recipes/search")
//    Call<RecipeResponse> getRecipeList2(
//            @Query("info") boolean info
//    );
}

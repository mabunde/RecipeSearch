package com.moringaschool.spoonacularapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.spoonacularapi.Constants;
import com.moringaschool.spoonacularapi.R;
import com.moringaschool.spoonacularapi.adapters.RecipeListAdapter;
import com.moringaschool.spoonacularapi.models.Result;
import com.moringaschool.spoonacularapi.models.RecipeResponse;
import com.moringaschool.spoonacularapi.network.RecipeClient;
import com.moringaschool.spoonacularapi.network.SpoonacularApi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeActivity extends AppCompatActivity {

    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recipeRecyclerview) RecyclerView mRecipeRecyclerview;
    @BindView(R.id.errorMessage) TextView mErrorMessage;

    private RecipeListAdapter mAdapter;
    private List<Result> mRecipe;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);


        getRecipeList();
    }
    public void getRecipeList(){
        SpoonacularApi myClient= RecipeClient.getClient();
        Call<RecipeResponse> call= myClient.getRecipeList(Constants.SPOONACULAR_API_KEY);
        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                hideProgressBar();
                if (response.isSuccessful()) {
                    mRecipe = response.body().getResults();
                    mAdapter = new RecipeListAdapter(RecipeActivity.this, mRecipe);
                    mRecipeRecyclerview.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipeActivity.this);
                    mRecipeRecyclerview.setLayoutManager(layoutManager);
                    mRecipeRecyclerview.setHasFixedSize(true);
                    showRecipeList();
                }else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                showErrorMessage();

            }
        });
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void showRecipeList() {
        mRecipeRecyclerview.setVisibility(View.VISIBLE);
    }
    private void showErrorMessage() {
        mErrorMessage.setText("Something went wrong. Please check you internet connection, and try again.");
        mErrorMessage.setVisibility(View.VISIBLE);
    }

}
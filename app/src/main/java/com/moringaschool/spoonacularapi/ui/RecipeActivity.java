package com.moringaschool.spoonacularapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
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
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentSearch;


    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recipeRecyclerview) RecyclerView mRecipeRecyclerview;
    @BindView(R.id.errorMessage) TextView mErrorMessage;

    private RecipeListAdapter mAdapter;
    private List<Result> mRecipe;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentSearch = mSharedPreferences.getString(Constants.PREFERENCES_SEARCH_KEY, null);
        if(mRecentSearch != null){
            fetchRecipe(mRecentSearch);
        }
    }
    private void addToSharedPreferences(String search) {
        mEditor.putString(Constants.PREFERENCES_SEARCH_KEY, search).apply();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.search_recipe);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String search) {
                addToSharedPreferences(search);
                fetchRecipe(search);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String search) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void fetchRecipe(String search){
        SpoonacularApi myClient= RecipeClient.getClient();
        Call<RecipeResponse> call= myClient.getRecipeList(Constants.SPOONACULAR_API_KEY,true,search);
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
                } else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                hideProgressBar();
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
    private void showUnsuccessfulMessage() {
        mErrorMessage.setText("Something went wrong. Please try again later");
        mErrorMessage.setVisibility(View.VISIBLE);
    }
    private void showErrorMessage() {
        mErrorMessage.setText("Something went wrong. Please check you internet connection, and try again.");
        mErrorMessage.setVisibility(View.VISIBLE);
    }

}
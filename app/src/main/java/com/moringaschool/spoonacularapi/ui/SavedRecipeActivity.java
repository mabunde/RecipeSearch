package com.moringaschool.spoonacularapi.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.spoonacularapi.Constants;
import com.moringaschool.spoonacularapi.R;
import com.moringaschool.spoonacularapi.adapters.FirebaseRecipeViewHolder;
import com.moringaschool.spoonacularapi.models.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedRecipeActivity extends AppCompatActivity {
    private DatabaseReference mRecipeReference;
    private ItemTouchHelper mItemTouchHelper;

    private FirebaseRecyclerAdapter<Result, FirebaseRecipeViewHolder> mFirebaseAdapter;

    @BindView(R.id.recipeRecyclerview) RecyclerView mRecipeRecyclerview;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance()
                .getCurrentUser();
        assert user != null;
        String uid = user.getUid();

        mRecipeReference = FirebaseDatabase.getInstance()
                .getReference(Constants.FIREBASE_CHILD_RECIPE)
                .child(uid);
//        Log.e("Dennis", String.valueOf(mRecipeReference));
        setUpFirebaseAdapter();

        hideProgressBar();
        showSavedRecipe();
    }
    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Result> options =
                new FirebaseRecyclerOptions.Builder<Result>()
                        .setQuery(mRecipeReference, Result.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Result, FirebaseRecipeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseRecipeViewHolder firebaseRecipeViewHolder,
                                            int position, @NonNull Result recipe) {
                firebaseRecipeViewHolder.bindRecipe(recipe);
            }
            @NonNull
            @Override
            public FirebaseRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item,
                        parent, false);
                return new FirebaseRecipeViewHolder(view);
            }
        };

        mRecipeRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecipeRecyclerview.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter != null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void showSavedRecipe() {
        mRecipeRecyclerview.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
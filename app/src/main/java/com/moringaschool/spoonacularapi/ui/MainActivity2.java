package com.moringaschool.spoonacularapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.spoonacularapi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity2 extends AppCompatActivity  implements View.OnClickListener{
    @BindView(R.id.searchRecipeButton) Button mSearchRecipeButton;
    @BindView(R.id.welcomeMessage) TextView mWelcomeMessage;
    @BindView(R.id.savedRecipeButton) Button mSavedRecipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);


        mSearchRecipeButton.setOnClickListener(this);
        mSavedRecipeButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        if(v == mSearchRecipeButton) {
            Intent intent = new Intent(MainActivity2.this, RecipeActivity.class);
            startActivity(intent);
        }

        if (v == mSavedRecipeButton) {
            Intent intent = new Intent(MainActivity2.this, SavedRecipeActivity.class);
            startActivity(intent);
        }
    }
}
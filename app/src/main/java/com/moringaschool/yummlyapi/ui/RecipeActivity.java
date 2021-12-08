package com.moringaschool.yummlyapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.yummlyapi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {

    ListView mListView;
    private String[] dishes = new String[]{"Fried fish", "Croissant", "Seafood paella", "Chicken rice", " Tacos", "Pork ribs",
            "Potato chips"};
    private String[] recipes = new String[]{"vegetable oil and fish", "baking flour", "shrimp and rice", "chicken and rice", "Cheddar cheese",
            "pork", "cooking oil and potatoes"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);



        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String recipe = ((TextView)view).getText().toString();
                Toast.makeText(RecipeActivity.this, recipe, Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();

    }
}
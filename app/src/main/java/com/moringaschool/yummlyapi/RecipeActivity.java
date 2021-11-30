package com.moringaschool.yummlyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;

public class RecipeActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] dishes = new String[] {"Fried fish","croissant","Seafood paella","Chicken rice"," Tacos","Pork ribs",
    "Potato chips"};
    private String[] recipies = new String[] {"vegetable oil","baking flour","shrimp and rice","chicken and rice","Cheddar cheese",
    "pork","cooking oil and potatoes"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }
}
package com.moringaschool.yummlyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;
    private String[] dishes = new String[]{"Fried fish", "Croissant", "Seafood paella", "Chicken rice", " Tacos", "Pork ribs",
            "Potato chips"};
    private String[] recipes = new String[]{"vegetable oil", "baking flour", "shrimp and rice", "chicken and rice", "Cheddar cheese",
            "pork", "cooking oil and potatoes"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        MyRecipeArrayAdapter adapter = new MyRecipeArrayAdapter(this, android.R.layout.simple_list_item_1, dishes, recipes); // the arguments must match constructor's parameters!
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String recipe = ((TextView)view).getText().toString();
                Toast.makeText(RecipeActivity.this, recipe, Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        mLocationTextView.setText("Here are all the dishes available: ");

    }
}
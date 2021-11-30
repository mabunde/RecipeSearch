package com.moringaschool.yummlyapi;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyRecipeArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipe;
    private String[] mIngredients;

    public MyRecipeArrayAdapter(Context mContext, int resource, String[] mRecipe, String[] mIngredients) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipe = mRecipe;
        this.mIngredients = mIngredients;
    }
    @Override
    public Object getItem(int position) {
        String restaurant = mRecipe[position];
        String cuisine = mIngredients[position];
        return String.format("%s \nServes great: %s", recipe, ingredients);
    }

    @Override
    public int getCount() {
        return mRecipe.length;
    }

}

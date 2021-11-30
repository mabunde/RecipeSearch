package com.moringaschool.yummlyapi;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyRecipeArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mDish;
    private String[] mRecipe;

    public MyRecipeArrayAdapter(Context mContext, int resource, String[] mDish, String[] mRecipe) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mDish = mDish;
        this.mRecipe = mRecipe;
    }
    @Override
    public Object getItem(int position) {
        String dish = mDish[position];
        String recipe = mRecipe[position];
        return String.format("%s \nServes great: %s", dish, recipe);
    }

    @Override
    public int getCount() {
        return mRecipe.length;
    }

}

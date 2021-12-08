package com.moringaschool.yummlyapi.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.yummlyapi.models.Result;
import com.moringaschool.yummlyapi.ui.RecipeDetailFragment;


import java.util.List;

public class RecipePagerAdapter extends FragmentPagerAdapter {
    private List<Result> mRecipe;

    public RecipePagerAdapter(@NonNull FragmentManager fm, int behavior, List<Result> recipe) {
        super(fm, behavior);
        mRecipe = recipe;
    }

    @Override
    public Fragment getItem(int position) {
        return RecipeDetailFragment.newInstance(mRecipe.get(position));
    }

    @Override
    public int getCount() {
        return mRecipe.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mRecipe.get(position).getTitle();
    }


}

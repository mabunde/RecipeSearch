package com.moringaschool.spoonacularapi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.spoonacularapi.Constants;
import com.moringaschool.spoonacularapi.R;
import com.moringaschool.spoonacularapi.models.Result;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeDetailFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.recipeImageView) ImageView mImageLabel;
    @BindView(R.id.recipeNameTextView) TextView mNameLabel;
    @BindView(R.id.sourceNameTextView) TextView mSourceNameTextView;
    @BindView(R.id.sourceURL) TextView mSourceURL;
    @BindView(R.id.instructionsTextView) TextView mInstructionsTextView;
    @BindView(R.id.saveRecipeButton) TextView mSaveRecipeButton;



    private Result mRecipe;

    public RecipeDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RecipeDetailFragment newInstance(Result recipe) {
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mRecipe.getImage()).into(mImageLabel);
        mNameLabel.setText(mRecipe.getTitle());
        mSourceNameTextView.setText(mRecipe.getSourceName());
        mSourceURL.setText(mRecipe.getSourceUrl());
        mInstructionsTextView.setText(mRecipe.getSummary());

        mSourceURL.setOnClickListener(this);
        mSaveRecipeButton.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        if (v == mSourceURL) {
            Intent webIntent = new Intent (Intent.ACTION_VIEW, Uri.parse(mRecipe.getSourceUrl()));
            startActivity(webIntent);
        }
        if(v ==mSaveRecipeButton){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference restaurantRef= FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_SEARCHED_RECIPE)
                    .child(uid);
            DatabaseReference pushRef = restaurantRef.push();
            String pushId = pushRef.getKey();
            mRecipe.setId(pushId);
            pushRef.setValue(mRecipe);

            Toast.makeText(getContext(), "Saved successfully", Toast.LENGTH_SHORT).show();

        }
    }


}
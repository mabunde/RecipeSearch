package com.moringaschool.spoonacularapi.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.spoonacularapi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewMainActivity extends AppCompatActivity  implements View.OnClickListener{
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.searchRecipeButton) Button mSearchRecipeButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.savedRecipeButton) Button mSavedRecipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);
        ButterKnife.bind(this);

        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mSearchRecipeButton.setOnClickListener(this);
        mSavedRecipeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == mSearchRecipeButton) {
            Intent intent = new Intent(NewMainActivity.this, RecipeActivity.class);
            startActivity(intent);
        }

        if (v == mSavedRecipeButton) {
            Intent intent = new Intent(NewMainActivity.this, SavedRecipeActivity.class);
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(NewMainActivity.this, SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
//    private void addToSharedPrefs(String username) {
//        mEditor.putString(Constants.USER_NAME, username).apply();
//    }
}
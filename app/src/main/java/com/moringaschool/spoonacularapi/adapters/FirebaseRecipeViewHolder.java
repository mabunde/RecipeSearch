package com.moringaschool.spoonacularapi.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.spoonacularapi.Constants;
import com.moringaschool.spoonacularapi.R;
import com.moringaschool.spoonacularapi.models.Result;
import com.moringaschool.spoonacularapi.ui.RecipeDetailsActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;
    public FirebaseRecipeViewHolder(View itemView){
        super(itemView);
        mView=itemView;
        mContext= itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindRestaurant(Result recipe){
        ImageView recipeImageView = (ImageView) mView.findViewById(R.id.recipeImageView);
        TextView recipeTitle =(TextView) mView.findViewById(R.id.recipeTitle);
        TextView recipeReadyInMinutes =(TextView)  mView.findViewById(R.id.recipeReadyInMinutes);
        TextView recipeTotalServing =(TextView) mView.findViewById(R.id.recipeTotalServing);
        TextView priceTextView =(TextView) mView.findViewById(R.id.priceTextView);

        Picasso.get().load(recipe.getImage()).into(recipeImageView);
        recipeTitle.setText(recipe.getTitle());
        recipeReadyInMinutes.setText("Ready in "+recipe.getReadyInMinutes()+ " minutes");
        recipeTotalServing.setText("Serving "+recipe.getServings()+ " people");
        priceTextView.setText("Cost "+recipe.getPricePerServing()+"$" );
    }
    @Override
    public void onClick(View view){
        final ArrayList<Result> recipe =new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RECIPE)
                .child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    recipe.add(snapshot.getValue(Result.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, RecipeDetailsActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("recipe", Parcels.wrap(recipe));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}

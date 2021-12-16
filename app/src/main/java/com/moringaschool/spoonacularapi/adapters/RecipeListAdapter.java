package com.moringaschool.spoonacularapi.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.spoonacularapi.R;
import com.moringaschool.spoonacularapi.models.Result;
import com.moringaschool.spoonacularapi.ui.RecipeDetailsActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder> {
    private Context mContext;
    private List<Result> mRecipe;

    public RecipeListAdapter(Context mContext, List<Result> mRecipe) {
        this.mContext = mContext;
        this.mRecipe = mRecipe;
    }

    @NonNull
    @Override
    public RecipeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item,parent,false);
        RecipeListViewHolder viewHolder=new RecipeListViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListViewHolder holder, int position) {
        holder.bindRecipeList(mRecipe.get(position ));
    }

    @Override
    public int getItemCount() {
        return mRecipe.size();
    }

    public class RecipeListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
        @BindView(R.id.recipeTitle) TextView mRecipeTitle;
        @BindView(R.id.recipeReadyInMinutes) TextView mRecipeReadyInMinutes;
        @BindView(R.id.recipeTotalServing) TextView mRecipeTotalServing;
        @BindView(R.id.priceTextView) TextView mPriceTextView;

        private Context mContext;

        public RecipeListViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext=itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindRecipeList( Result result){
            Picasso.get().load(result.getImage()).into(mRecipeImageView);
            mRecipeTitle.setText(result.getTitle());
            mRecipeReadyInMinutes.setText("Ready in "+result.getReadyInMinutes()+ " minutes");
            mRecipeTotalServing.setText("Serving "+result.getServings()+ " people");
            mPriceTextView.setText("Cost "+result.getPricePerServing()+"$" );

        }
        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RecipeDetailsActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("recipe", Parcels.wrap(mRecipe));
            mContext.startActivity(intent);
        }
    }
}

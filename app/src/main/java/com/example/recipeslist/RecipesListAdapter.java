package com.example.recipeslist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipesListAdapter
extends RecyclerView.Adapter<RecipesListAdapter.RecipeViewHolder> {
    private final LinkedList<Recipe> mRecipeList;
    private final LayoutInflater mInflater;
    private final OnRecipeListener mOnRecipeListener;
    Activity activity;



    public RecipesListAdapter(Context context, LinkedList<Recipe> resipeList, OnRecipeListener onRecipeListener){
        mInflater = LayoutInflater.from(context);
        this.mRecipeList=resipeList;
        this.mOnRecipeListener = onRecipeListener;
    }


    @NonNull

    @Override
    public RecipesListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item,
                null);
        return new RecipeViewHolder(mItemView, this, mOnRecipeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesListAdapter.RecipeViewHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.titleItemView.setText(mCurrent.getName());
        holder.caloriesItemView.setText(mCurrent.getNutrition());
        holder.photoItemView.setImageDrawable(mCurrent.getImage());
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView titleItemView;
        public final TextView caloriesItemView;
        public final ImageView photoItemView;
        final RecipesListAdapter mAdapter;
        OnRecipeListener onRecipeListener;

        public RecipeViewHolder (View itemView, RecipesListAdapter adapter, OnRecipeListener onRecipeListener){
            super(itemView);
            //set all the elements in aim to fill them lately
            titleItemView = itemView.findViewById(R.id.title);
            caloriesItemView = itemView.findViewById(R.id.calories);
            photoItemView = itemView.findViewById(R.id.image);
            this.mAdapter=adapter;
            this.onRecipeListener = onRecipeListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRecipeListener.onRecipeClick(getAdapterPosition());
        }
    }

    public interface OnRecipeListener{
        void onRecipeClick(int position);
    }
}

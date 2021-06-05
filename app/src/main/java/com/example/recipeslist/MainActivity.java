package com.example.recipeslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.LinkedList;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements RecipesListAdapter.OnRecipeListener {
    private LinkedList<Recipe> mRecipeList;
    private RecyclerView mRecyclerView;
    private RecipesListAdapter mAdapter;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.my_recycler_view);

        db = new DatabaseHelper(this);

        mRecipeList = new LinkedList<>();
        fetchData();

        /*// Create an adapter and supply the data to be displayed.
        mAdapter = new RecipesListAdapter(this, mRecipeList, this);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
         */
    }

    public void fetchData(){
        db = new DatabaseHelper(this);
        try {
            db.createDataBase();
            db.openDataBase();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //get all recipes
        //mRecipeList = db.getAllRecipes(this);
        //get only breakfast
        //mRecipeList = db.getBreakfast(this);
        //get only lunch
        //mRecipeList = db.getLunch(this);
        //get only dinner
        //mRecipeList = db.getDinner(this);
        //get only snacks
        mRecipeList = db.getSnacks(this);
        //Toast.makeText(MainActivity.this, "Success= "+ mRecipeList.toString(), Toast.LENGTH_SHORT).show();
        mAdapter = new RecipesListAdapter(this, mRecipeList, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onRecipeClick(int position) {
        Log.d(TAG, "onRecipeClick: clicked.");
        
    }


}
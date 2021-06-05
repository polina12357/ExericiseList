package com.example.recipeslist;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Recipe {
    private String rName;
    private String rInstructions;
    private String rIngradients;
    private String rNutrition;
    private Drawable rResultImage;
    private String rType;

    Recipe(String name, String ingradients, String instructions, String Nutrition, String Type, Drawable image){
        this.rName = name;
        this.rIngradients = ingradients;
        this.rInstructions = instructions;
        this.rNutrition = Nutrition;
        this.rType = Type;
        this.rResultImage = image;
    }

    public String getName(){ return rName;}
    public String getInstructions(){return rInstructions;}
    public String getIngradients(){return rIngradients;}
    public String getNutrition(){return rNutrition;}
    public String getType(){return rType;}
    public Drawable getImage(){return rResultImage;}

    @Override
    public String toString() {
        return "Recipe{" +
                "rName='" + rName + '\'' +
                ", rInstructions='" + rInstructions + '\'' +
                ", rIngradients='" + rIngradients + '\'' +
                ", rNutrition='" + rNutrition + '\'' +
                ", rResultImage=" + rResultImage +
                ", rType='" + rType + '\'' +
                '}';
    }
}

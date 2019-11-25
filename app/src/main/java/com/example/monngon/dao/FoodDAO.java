package com.example.monngon.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.monngon.database.Database;
import com.example.monngon.model.Category;
import com.example.monngon.model.Food;

public class FoodDAO {
    public static final String TABLE_NAME = "FOOD";
    public static final String SQL_FOOD = " CREATE TABLE FOOD( food_ID text primary key, food_category_ID text, food_name text, food_ingredient text"+
            "food_making text, food_status text, food_session text)";
    private SQLiteDatabase db;
    private Database database;
    public FoodDAO(Context context) {
        database = new Database(context);
        db = database.getWritableDatabase();
    }
    public  boolean insertFood(Food food){
        ContentValues values = new ContentValues();
        values.put("food_ID",food.getFood_ID());
        values.put("food_category_ID",food.getFood_category_ID());
        values.put("food_name",food.getFood_name());
        values.put("food_ingredient",food.getFood_ingredient());
        values.put("food_making",food.getFood_making());
        values.put("food_status",food.getFood_status());
        values.put("food_session",food.getFood_session());
        long resuilt = db.insert(TABLE_NAME, null, values);
        try {
            if (resuilt == -1){
                return false;
            }
        }catch (Exception e){
            Log.e("tag",e.toString());
            return false;
        }
        return true;
    }

}

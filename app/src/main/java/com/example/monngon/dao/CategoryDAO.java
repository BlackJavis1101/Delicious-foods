package com.example.monngon.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.monngon.database.Database;
import com.example.monngon.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    public static final String TABLE_NAME = "CATEGORY_FOOD";
    public static final String SQL_CATEGORY = " CREATE TABLE CATEGORY_FOOD( CategoryID text primary key, CategoryName text, Category_Description text)";
    private SQLiteDatabase db;
    private Database database;

    public CategoryDAO(Context context) {
        database = new Database(context);
        db = database.getWritableDatabase();
    }

    public boolean insertCategory(Category category) {
        ContentValues values = new ContentValues();
        values.put("CategoryID", category.getId_category());
        values.put("CategoryName", category.getCategory());
        values.put("Category_Description", category.getDescription());
        Long resuilt = db.insert(TABLE_NAME, null, values);
        try {
            if (resuilt == -1) {
                return false;
            }
        } catch (Exception e) {
            Log.e("tag", e.toString());
            return false;
        }
        return true;
    }

    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Category category = new Category();
            category.setId_category(cursor.getString(0));
            category.setCategory(cursor.getString(1));
            category.setDescription(cursor.getString(2));
            categories.add(category);
            cursor.moveToNext();
        }
        return categories;
    }
}



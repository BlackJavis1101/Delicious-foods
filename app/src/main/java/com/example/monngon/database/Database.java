package com.example.monngon.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.monngon.dao.CategoryDAO;
import com.example.monngon.dao.FoodDAO;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MonNgon";
    public static final int VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CategoryDAO.SQL_CATEGORY);
        db.execSQL(FoodDAO.SQL_FOOD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoryDAO.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ FoodDAO.TABLE_NAME);
        onCreate(db);
    }
}

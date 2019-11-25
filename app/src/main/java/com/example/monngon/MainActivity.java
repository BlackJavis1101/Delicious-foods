package com.example.monngon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.monngon.dao.CategoryDAO;
import com.example.monngon.model.Category;

public class MainActivity extends AppCompatActivity {
    CardView cv_food_category, cv_my_recipe;
    Intent intent;
    CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Delicious foods");
        cv_food_category = findViewById(R.id.cv_food_category);
        cv_food_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, FoodCategoryActivity.class);
                startActivity(intent);
            }
        });
        cv_my_recipe = findViewById(R.id.cv_my_recipe);
        cv_my_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MyRecipeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_main_add_to_mycecipe:
                intent = new Intent(MainActivity.this, MyRecipeActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_main_show:
                    insertDuLieu();
                return true;
            case R.id.item_main_add_to_category:
                intent = new Intent(MainActivity.this, AddCategoryActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void insertDuLieu(){
        categoryDAO = new CategoryDAO(this);
        String ID_category = "Soup1";
        String name_category = "Soup";
        String desc_category = "a liquid dish, typically made by boiling meat, fish, or vegetables, etc., in stock or water.";
        Category category = new Category(ID_category,name_category,desc_category);
        categoryDAO.insertCategory(category);
//        category = null;
        String ID2_category = "Dessert2";
        String name2_category = "Dessert";
        String desc2_category = "the sweet course eaten at the end of a meal.";
         category = new Category(ID2_category,name2_category,desc2_category);
        categoryDAO.insertCategory(category);
//        categoryDAO = new CategoryDAO(this);
//        String ID_category = ed_ID_Category.getText().toString();
//        String name_category = ed_Name_Category.getText().toString();
//        String desc_category = ed_Desc.getText().toString();
//        if (ID_category.length() == 0 || name_category.length() == 0 || desc_category.length() == 0) {
//            Toast.makeText(getApplicationContext(), " You must enter full information", Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            Category category = new Category(ID_category, name_category, desc_category);
//            boolean isInsertrue = categoryDAO.insertCategory(category);
//            if (isInsertrue) {
//
//                Toast.makeText(getApplicationContext(), "success!", (Toast.LENGTH_SHORT)).show();
//            } else {
//                Toast.makeText(getApplicationContext(), "Please try again!", (Toast.LENGTH_SHORT)).show();
//            }
//
//        }
//
//    }
    }
}

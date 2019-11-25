package com.example.monngon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.monngon.dao.CategoryDAO;
import com.example.monngon.dao.FoodDAO;
import com.example.monngon.model.Category;
import com.example.monngon.model.Food;

import java.util.List;

public class MyRecipeActivity extends AppCompatActivity {
    EditText edt_food_id_my_recope, edt_name_my_recope, edt_ingredients_my_recope, edt_cook_my_recope;
    Spinner spn_category;
    Intent intent;
    List<Category> categoryList;
    FoodDAO foodDAO;
    Button btn_add_my_recipe, btn_cancel_my_recipe, btn_show_my_recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe);
        setTitle("My Recipe");
        edt_food_id_my_recope = findViewById(R.id.edt_food_id_my_recope);
        edt_name_my_recope = findViewById(R.id.edt_name_my_recope);
        edt_cook_my_recope = findViewById(R.id.edt_cook_my_recope);
        edt_ingredients_my_recope = findViewById(R.id.edt_ingredients_my_recope);
        spn_category = findViewById(R.id.spn_category);
        btn_add_my_recipe =findViewById(R.id.btn_add_my_recipe);
        btn_cancel_my_recipe = findViewById(R.id.btn_cancel_my_recipe);
        btn_show_my_recipe = findViewById(R.id.btn_show_my_recipe);

        btn_add_my_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertFood();
            }
        });
        btn_cancel_my_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MyRecipeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_show_my_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MyRecipeActivity.this,FoodCategoryActivity.class);
                startActivity(intent);
            }
        });

    }

    public void insertFood() {
        foodDAO = new FoodDAO(this);
        String food_ID = edt_food_id_my_recope.getText().toString();
        String food_name = edt_name_my_recope.getText().toString();
        String food_coook = edt_cook_my_recope.getText().toString();
        String food_category = spn_category.getSelectedItem().toString();
        String food_ingredients = edt_ingredients_my_recope.getText().toString();
        if (food_ID.length() == 0 || food_name.length() == 0 || food_coook.length() == 0 || food_ingredients.length() == 0) {
            Toast.makeText(getApplicationContext(), " You must enter full information", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Food food = new Food(food_ID, food_category, food_name, food_coook, food_ingredients, null, null);
            boolean isInsertTrue = foodDAO.insertFood(food);
            if (isInsertTrue) {
                Toast.makeText(getApplicationContext(), "success!", (Toast.LENGTH_SHORT)).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please try again!", (Toast.LENGTH_SHORT)).show();
            }
        }
    }

}

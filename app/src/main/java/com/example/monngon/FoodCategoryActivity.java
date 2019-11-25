package com.example.monngon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.monngon.dao.CategoryDAO;
import com.example.monngon.model.Category;

import java.util.List;

public class FoodCategoryActivity extends AppCompatActivity {
    CategoryDAO categoryDAO;
    List<Category> categoryList;
    Spinner spn_category;
    String id_category = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);
        spn_category = findViewById(R.id.spn_category);
        getCategory();
        spn_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                id_category =
//                        categoryList.get(spn_category.getSelectedItemPosition()).getId_category();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_food_catetory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_food_show_my_recipe:

                return true;
            case R.id.item_food_show_favorite:

                return true;
            case R.id.item_food_menu:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getCategory() {
        categoryDAO = new CategoryDAO(FoodCategoryActivity.this);
        categoryList = categoryDAO.getAllCategory();
        ArrayAdapter<Category> adapter = new ArrayAdapter<Category>(this, android.R.layout.simple_spinner_item, categoryList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_category.setAdapter(adapter);


    }
}

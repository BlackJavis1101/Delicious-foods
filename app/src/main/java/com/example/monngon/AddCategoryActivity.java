package com.example.monngon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.monngon.dao.CategoryDAO;
import com.example.monngon.model.Category;

public class AddCategoryActivity extends AppCompatActivity {
    EditText ed_ID_Category, ed_Name_Category, ed_Desc;
    Button btn_add_category, btn_cancle_category, btn_show_category;
    Intent intent;
    CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        setTitle("add categories");
        ed_ID_Category = findViewById(R.id.edt_category_ID);
        ed_Name_Category = findViewById(R.id.edt_category_Name);
        ed_Desc = findViewById(R.id.edt_category_description);
        btn_add_category = findViewById(R.id.btn_add_category);
        btn_add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertCategory();
            }
        });
        btn_cancle_category = findViewById(R.id.btn_cancel_category);
        btn_cancle_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AddCategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void insertCategory() {
        categoryDAO = new CategoryDAO(this);
        String ID_category = ed_ID_Category.getText().toString();
        String name_category = ed_Name_Category.getText().toString();
        String desc_category = ed_Desc.getText().toString();
        if (ID_category.length() == 0 || name_category.length() == 0 || desc_category.length() == 0) {
            Toast.makeText(getApplicationContext(), " You must enter full information", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Category category = new Category(ID_category, name_category, desc_category);
            boolean isInsertrue = categoryDAO.insertCategory(category);
            if (isInsertrue) {

                Toast.makeText(getApplicationContext(), "success!", (Toast.LENGTH_SHORT)).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please try again!", (Toast.LENGTH_SHORT)).show();
            }

        }

    }


}

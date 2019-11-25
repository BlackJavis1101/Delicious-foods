package com.example.monngon.model;

public class Food {
    private String food_category_ID;
    private  String food_ID;
    private String food_name;
    private String	food_ingredient;
    private String food_making;
    private String food_status;
    private  String food_session;

    public Food() {
    }

    public Food(String food_category_ID, String food_ID, String food_name, String food_ingredient, String food_making, String food_status, String food_session) {
        this.food_category_ID = food_category_ID;
        this.food_ID = food_ID;
        this.food_name = food_name;
        this.food_ingredient = food_ingredient;
        this.food_making = food_making;
        this.food_status = food_status;
        this.food_session = food_session;
    }

    public String getFood_category_ID() {
        return food_category_ID;
    }

    public void setFood_category_ID(String food_category_ID) {
        this.food_category_ID = food_category_ID;
    }

    public String getFood_ID() {
        return food_ID;
    }

    public void setFood_ID(String food_ID) {
        this.food_ID = food_ID;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_ingredient() {
        return food_ingredient;
    }

    public void setFood_ingredient(String food_ingredient) {
        this.food_ingredient = food_ingredient;
    }

    public String getFood_making() {
        return food_making;
    }

    public void setFood_making(String food_making) {
        this.food_making = food_making;
    }

    public String getFood_status() {
        return food_status;
    }

    public void setFood_status(String food_status) {
        this.food_status = food_status;
    }

    public String getFood_session() {
        return food_session;
    }

    public void setFood_session(String food_session) {
        this.food_session = food_session;
    }
}

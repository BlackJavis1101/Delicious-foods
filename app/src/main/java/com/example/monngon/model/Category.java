package com.example.monngon.model;

public class Category {
    private String id_category;
    private String category;
    private String Description;

    public Category(String id_category, String category, String description) {
        this.id_category = id_category;
        this.category = category;
        Description = description;
    }

    public Category() {

    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return this.category;
    }
}

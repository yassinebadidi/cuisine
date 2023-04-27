package fr.training.cuisine.model;

public class Category {
    private int id;
    private String name;
    private String CategoryPicUr;

    public Category() {
    }

    public Category(String name, String categoryPicUr) {
        this.name = name;
        CategoryPicUr = categoryPicUr;
    }

    public Category(int id, String name, String categoryPicUr) {
        this.id = id;
        this.name = name;
        CategoryPicUr = categoryPicUr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryPicUr() {
        return CategoryPicUr;
    }

    public void setCategoryPicUr(String categoryPicUr) {
        CategoryPicUr = categoryPicUr;
    }
}

package fr.training.cuisine.model;

import java.time.LocalDateTime;

public class Recette {
    private int id;
    private String name;
    private LocalDateTime createdAt;
    private Category category;
    private String ingredient;
    private String steps;

    private User user;

    public Recette() {
    }

    public Recette(int id, String name, LocalDateTime createdAt, Category category, String ingredient, String steps, User user) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.category = category;
        this.ingredient = ingredient;
        this.steps = steps;
        this.user = user;
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

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

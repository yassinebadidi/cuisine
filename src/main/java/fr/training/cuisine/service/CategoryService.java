package fr.training.cuisine.service;

import fr.training.cuisine.dao.JdbcDao.CategoryJdbcDao;
import fr.training.cuisine.dao.interfaceDao.CategoryDao;
import fr.training.cuisine.model.Category;

import java.util.List;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryJdbcDao();

    public Category findCategoryById(int categoryId){
        return categoryDao.findById(categoryId);
    }

    public List<Category> fetchAllCategorys(){
        return categoryDao.findAll();
    }
}

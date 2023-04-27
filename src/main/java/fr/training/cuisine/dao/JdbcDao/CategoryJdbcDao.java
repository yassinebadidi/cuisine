package fr.training.cuisine.dao.JdbcDao;

import fr.training.cuisine.dao.ConnectionManager;
import fr.training.cuisine.dao.interfaceDao.CategoryDao;
import fr.training.cuisine.model.Category;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDao implements CategoryDao {
    @Override
    public Category create(Category entity) {
        return null;
    }

    @Override
    public List<Category> findAll() {

        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT * FROM categorys";

        List<Category> categorys = new ArrayList<>();

        try(Statement pst = connection.createStatement()){
            ResultSet result = pst.executeQuery(query);
            while(result.next()){
                Category c = new Category(
                        result.getInt("id"),
                        result.getString("category_name"),
                        result.getString("categoryPicUrl")
                );
                categorys.add(c);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return categorys;
    }

    @Override
    public Category findById(Integer categoryId) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT * FROM categorys WHERE id=?";
        Category categoryFound = new Category();
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, categoryId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                categoryFound = new Category(
                        rs.getInt("id"),
                        rs.getString("category_name"),
                        rs.getString("categoryPicUrl")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryFound;
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(Category entity) {

    }
}

package fr.training.cuisine.dao.JdbcDao;

import fr.training.cuisine.dao.ConnectionManager;
import fr.training.cuisine.dao.interfaceDao.RecetteDao;
import fr.training.cuisine.model.Category;
import fr.training.cuisine.model.Recette;
import fr.training.cuisine.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetteJdbcDao implements RecetteDao {
    @Override
    public Recette create(Recette entity) {
        return null;
    }

    @Override
    public List<Recette> findAll() {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT r.id, r.name, r.created_at, c.id, r.ingredient, r.steps, u.id, " +
                "c.id AS 'category_id', " +
                "c.category_name AS 'category_name', " +
                "c.categoryPicUrl AS 'categoryPicUrl', " +
                "u.id AS 'user_id', " +
                "u.firstname AS 'user_firstname', " +
                "u.lastname AS 'user_lastname' " +
                "FROM recettes r " +
                "JOIN categorys c ON r.category_fk_id = c.id " +
                "JOIN users u ON r.user_fk_id = u.id";

        List<Recette> recettes = new ArrayList<>();

        try(Statement pst = connection.createStatement()){
            ResultSet result = pst.executeQuery(query);
            while(result.next()){
                Recette r = new Recette(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getTimestamp("created_at").toLocalDateTime(),
                        new Category(
                                result.getString("category_name"),
                                result.getString("categoryPicUrl")),
                        result.getString("ingredient"),
                        result.getString("steps"),
                        new User(
                                result.getString("user_firstname"),
                                result.getString("user_lastname")
                                )
                );
                recettes.add(r);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return recettes;
    }

    @Override
    public Recette findById(Integer integer) {
        return null;
    }

    @Override
    public void update(Recette entity) {

    }

    @Override
    public void delete(Recette entity) {

    }
}

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
    public Recette create(Recette recetteCreated) {

        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO recettes(name,created_at,category_fk_id,ingredient,steps,user_fk_id) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement pst = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {


            pst.setString(1, recetteCreated.getName());
            pst.setTimestamp(2, Timestamp.valueOf(recetteCreated.getCreatedAt()));
            pst.setInt(3, recetteCreated.getCategory().getId());
            pst.setString(4, recetteCreated.getIngredient());
            pst.setString(5, recetteCreated.getSteps());
            pst.setInt(6, recetteCreated.getUser().getId());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    recetteCreated.setId(generatedKeys.getInt(1));
                    return recetteCreated;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public Recette findById(Integer RecetteId) {
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
                       "JOIN users u ON r.user_fk_id = u.id WHERE r.id =?";

        Recette postFound = new Recette();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, RecetteId);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postFound;
    }

    @Override
    public void update(Recette entity) {

    }

    @Override
    public void delete(Recette entity) {

    }
}

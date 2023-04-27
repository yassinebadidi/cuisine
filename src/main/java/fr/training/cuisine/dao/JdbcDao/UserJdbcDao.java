package fr.training.cuisine.dao.JdbcDao;

import fr.training.cuisine.dao.ConnectionManager;
import fr.training.cuisine.dao.interfaceDao.UserDao;
import fr.training.cuisine.model.User;

import java.sql.*;
import java.util.List;

public class UserJdbcDao implements UserDao {

    @Override
    public User create(User CreatedUser) {

        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO users (firstname, lastname, email, picUrl, password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, CreatedUser.getFirstname());
            pst.setString(2, CreatedUser.getLastname());
            pst.setString(3, CreatedUser.getEmail());
            pst.setString(4, CreatedUser.getPicUrl());
            pst.setString(5, CreatedUser.getPassword());
            int result = pst.executeUpdate();
            if (result == 1) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    Integer id = generatedKeys.getInt(1);
                    CreatedUser.setId(id);
                    return CreatedUser;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }


    @Override
    public User findByNameFisrtname(String firstname, String lastname) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, firstname, lastname, password FROM users WHERE firstname=? AND lastname =?";
        User userFound = new User();
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                userFound = new User(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }
}

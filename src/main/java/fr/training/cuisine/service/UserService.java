package fr.training.cuisine.service;

import fr.training.cuisine.dao.JdbcDao.UserJdbcDao;
import fr.training.cuisine.dao.interfaceDao.UserDao;
import fr.training.cuisine.model.User;

import java.util.stream.Collectors;

public class UserService {
    private UserDao userDao = new UserJdbcDao();


    public boolean login(String firstname, String lastname,String password) {
        User userFound = userDao.findByNameFisrtname(firstname,lastname);
        if (userFound != null) {
            return userFound.getPassword().equals(password);
        }
        return false;
    }
    public  User findByNameAndFirstname(String firstname,String lastname){
        return userDao.findByNameFisrtname(firstname,lastname);
    }

/*    public List<UserDto> findAll() {
        return userDao.findAll().stream()
                .map(user -> user.toDto())
                .collect(Collectors.toList());
    }*/
}

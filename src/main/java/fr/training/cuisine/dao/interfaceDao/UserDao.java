package fr.training.cuisine.dao.interfaceDao;

import fr.training.cuisine.dao.GenericDao;
import fr.training.cuisine.model.User;

public interface UserDao extends GenericDao<User, Integer> {
    User findByNameFisrtname(String firstname, String lastname);
}

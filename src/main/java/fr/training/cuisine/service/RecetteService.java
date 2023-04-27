package fr.training.cuisine.service;

import fr.training.cuisine.dao.JdbcDao.RecetteJdbcDao;
import fr.training.cuisine.dao.interfaceDao.RecetteDao;
import fr.training.cuisine.model.Category;
import fr.training.cuisine.model.Recette;
import fr.training.cuisine.model.User;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class RecetteService {
    private final RecetteDao recetteDao = new RecetteJdbcDao();

    public List<Recette> fechAllRecettes(){
        return recetteDao.findAll();
    }

    public Recette createRecette(String name, int idCategory, String ingredient,
                                 String steps, String userFirstname , String userLastname) throws SQLException {
        //getCategory :
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.findCategoryById(idCategory);

        //getUser :
        UserService userService = new UserService();
        User user = userService.findByNameAndFirstname(userFirstname,userLastname);

        //setTime
        LocalDateTime cratedAt = LocalDateTime.now();
        Recette recetteCreated = new Recette(name, cratedAt,category,ingredient,steps,user);

        return recetteDao.create(recetteCreated);
    }
}

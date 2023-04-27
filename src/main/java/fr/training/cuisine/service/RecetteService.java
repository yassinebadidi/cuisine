package fr.training.cuisine.service;

import fr.training.cuisine.dao.JdbcDao.RecetteJdbcDao;
import fr.training.cuisine.dao.interfaceDao.RecetteDao;
import fr.training.cuisine.model.Recette;

import java.util.List;

public class RecetteService {
    private RecetteDao recetteDao = new RecetteJdbcDao();

    public List<Recette> fechAllRecettes(){
        return recetteDao.findAll();
    }
}

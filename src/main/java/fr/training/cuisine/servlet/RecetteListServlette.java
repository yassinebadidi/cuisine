package fr.training.cuisine.servlet;

import fr.training.cuisine.model.Recette;
import fr.training.cuisine.service.RecetteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = RecetteListServlette.URL)
public class RecetteListServlette extends HttpServlet {
    public static final String URL = "/recettes";
    public static final String path = "/WEB-INF/recette_list.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecetteService recetteService = new RecetteService();
        List<Recette> recettes = recetteService.fechAllRecettes();

        req.setAttribute("recettes", recettes);
        req.getRequestDispatcher(path).forward(req,resp);
    }
}

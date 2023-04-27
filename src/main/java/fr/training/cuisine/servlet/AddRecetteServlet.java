package fr.training.cuisine.servlet;

import fr.training.cuisine.model.Category;
import fr.training.cuisine.model.User;
import fr.training.cuisine.service.CategoryService;
import fr.training.cuisine.service.RecetteService;
import fr.training.cuisine.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = AddRecetteServlet.URL)
public class AddRecetteServlet extends HttpServlet {
    public static final String URL ="/add-recette";
    public static final String path = "/WEB-INF/add-recette.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> categorys = new CategoryService().fetchAllCategorys();

        req.setAttribute("categorys", categorys);
        req.getRequestDispatcher(path).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getUser
        HttpSession session = req.getSession();
        String userFirstname = (String) session.getAttribute("firstname");
        String userLastname = (String) session.getAttribute("lastname");

        // getCategory :
        int idCategory = Integer.parseInt(req.getParameter("categoryId"));

        // setRecette :
        String name = req.getParameter("name");
        String ingredient = req.getParameter("ingredient");
        String steps = req.getParameter("steps");

        RecetteService recetteService = new RecetteService();
        try {
            recetteService.createRecette(name,idCategory,ingredient,steps,userFirstname,userLastname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath() + RecetteListServlette.URL);
    }
}

package servlet;

import manager.CarManager;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarManager carManager=new CarManager();
        List<Car> allCars = carManager.getAllCars();
        req.setAttribute("allcars",allCars);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}

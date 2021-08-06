package servlet;

import manager.CarManager;
import manager.ClientManager;
import model.Car;
import model.Clients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/price")
public class PricingServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarManager carManager=new CarManager();
        ClientManager clients=new ClientManager();
        List<Car> allCars = carManager.getAllCars();


        req.setAttribute("allcars",allCars);
        req.getRequestDispatcher("pricing.jsp").forward(req, resp);
    }
}

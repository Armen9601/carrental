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

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarManager carManager=new CarManager();
        List<Car> allCars = carManager.getAllCars();
        ClientManager clientManager=new ClientManager();
        List<Clients> client = clientManager.getAllClients();
        req.setAttribute("allclients",client);
        req.setAttribute("allcars",allCars);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

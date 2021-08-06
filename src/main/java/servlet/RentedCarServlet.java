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

@WebServlet(urlPatterns = "/rentedCars")
public class RentedCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientManager clientManager=new ClientManager();
        CarManager carManager=new CarManager();
        List<Clients> client = clientManager.getAllClients();
//        for (Clients clients : client) {
//            Car byID = carManager.getByID(clients.getCarID());
//            req.setAttribute("id",byID);
//        }
        req.setAttribute("allclients",client);
        req.getRequestDispatcher("rentedcars.jsp").forward(req, resp);
    }
}

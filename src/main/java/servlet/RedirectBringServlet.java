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

@WebServlet(urlPatterns = "/bring")
public class RedirectBringServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientManager clients=new ClientManager();
        CarManager carManager= new CarManager();
        String type = req.getParameter("type");
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        List<Clients> allClients = clients.getAllClients();
        for (Clients allClient : allClients) {
            if (allClient.getEmail().equalsIgnoreCase(type) && i==allClient.getCarID()){
                clients.updateClient(allClient);
                Car byID = carManager.getByID(i);
                carManager.updateCars(byID);
            }
        }
        resp.sendRedirect("/price");
    }
}

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/rentCar")
public class RentCarServlet extends HttpServlet {
    static ClientManager clientManager = new ClientManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        int clientAge = Integer.parseInt(age);
        String driverLicense = req.getParameter("drive");
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        String email = req.getParameter("email");
        CarManager carManager = new CarManager();
        Car byID = carManager.getByID(i);
        carManager.updateCar(byID);

        Clients client = new Clients();
        client.setName(name);
        client.setSurName(surname);
        client.setEmail(email);
        client.setAge(clientAge);
        client.setDriverLicenseNumber(driverLicense);
        client.setCarID(i);
        Clients byEmail = clientManager.getByEmail(email);
        if (byEmail == null) {
            clientManager.register(client);
        }


        req.setAttribute("message", "your rent adopted");
        resp.sendRedirect("/home");
    }
}

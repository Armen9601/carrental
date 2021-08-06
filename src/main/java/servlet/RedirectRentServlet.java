package servlet;

import manager.CarManager;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/rent")
public class RedirectRentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarManager carManager= new CarManager();
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        Car byID = carManager.getByID(i);
        req.setAttribute("detail",byID);
        req.getRequestDispatcher("rent.jsp").forward(req, resp);
    }
}

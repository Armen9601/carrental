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

@WebServlet(urlPatterns = "/details")
public class CarDetailsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        CarManager carManager=new CarManager();
        List<Car> allCars = carManager.getAllCars();
        Car byID = carManager.getByID(i);
        req.setAttribute("allcars",allCars);

        req.setAttribute("detail",byID);
        req.getRequestDispatcher("car-single.jsp").forward(req,resp);
    }
}

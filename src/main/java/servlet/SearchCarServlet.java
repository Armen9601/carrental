package servlet;

import manager.CarManager;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        CarManager carManager=new CarManager();
        List<Car> carList=new ArrayList<>();
        List<Car> allCars = carManager.getAllCars();
        for (Car allCar : allCars) {
           if (allCar.getBrand().equalsIgnoreCase(brand) || allCar.getModel().equalsIgnoreCase(model)){

               carList.add(allCar);
           }
        }
        req.setAttribute("allcars",carList);
        req.getRequestDispatcher("carsearch.jsp").forward(req, resp);
    }
}

package servlet;

import manager.CarManager;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addCar")
public class AddCarServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarManager carManager = new CarManager();
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String year = req.getParameter("year");
        int i = Integer.parseInt(year);
        String matorVolume = req.getParameter("matorVolume");
        double v = Double.parseDouble(matorVolume);
        String price = req.getParameter("price");
        double v1 = Double.parseDouble(price);
        String picture = req.getParameter("picture");

        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(i);
        car.setMatorVolume(v);
        car.setPrice(v1);
        car.setPicUrl(picture);
        car.isRented();
        carManager.addCar(car);

        resp.sendRedirect("/admin");
    }
}

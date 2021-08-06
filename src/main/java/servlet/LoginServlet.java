package servlet;

import manager.CarManager;
import manager.ClientManager;
import model.Admin;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        ClientManager clientManager=new ClientManager();
        Admin admin = clientManager.getByEmailAndPassword(email, password);
        if (admin.getEmail().equals(email)&&admin.getPassword().equals(password)){
            resp.sendRedirect("/page");
        }else{
            req.setAttribute("message", "invalid login or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        }
    }
}

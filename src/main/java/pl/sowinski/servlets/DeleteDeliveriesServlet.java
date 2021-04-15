package pl.sowinski.servlets;

import pl.sowinski.Dao.DeliveriesDao;
import pl.sowinski.domain.Deliveries;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/delete")
public class DeleteDeliveriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DeliveriesDao deliveriesDao = new DeliveriesDao();
        Deliveries deliveries = deliveriesDao.delete(id);
        request.setAttribute("delete", deliveries);

        getServletContext().getRequestDispatcher("/app/landing").forward(request,response);
    }
}

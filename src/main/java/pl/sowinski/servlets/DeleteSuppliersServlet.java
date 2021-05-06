package pl.sowinski.servlets;

import pl.sowinski.Dao.DeliveriesDao;
import pl.sowinski.Dao.SuppliersDao;
import pl.sowinski.domain.Deliveries;
import pl.sowinski.domain.Suppliers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/delete/suppliers")
public class DeleteSuppliersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SuppliersDao suppliersDao = new SuppliersDao();
        Suppliers suppliers = suppliersDao.delete(id);
        request.setAttribute("delete", suppliers);

        getServletContext().getRequestDispatcher("/app/add/suppliers").forward(request, response);

    }
}

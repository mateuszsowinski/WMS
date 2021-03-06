package pl.sowinski.servlets;

import pl.sowinski.Dao.SuppliersDao;
import pl.sowinski.domain.Suppliers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/add/suppliers")
public class SuppliersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Suppliers suppliers = new Suppliers();
        suppliers.setName(name);

        SuppliersDao suppliersDao = new SuppliersDao();
        suppliersDao.create(suppliers);
        response.sendRedirect(request.getContextPath() +"/app/landing");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SuppliersDao suppliersDao = new SuppliersDao();
        request.setAttribute("suppliers", suppliersDao.readAll());
        getServletContext().getRequestDispatcher("/WEB-INF/suppliersForm.jsp").forward(request, response);
    }
}

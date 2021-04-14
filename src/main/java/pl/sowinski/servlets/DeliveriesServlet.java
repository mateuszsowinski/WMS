package pl.sowinski.servlets;

import pl.sowinski.Dao.DeliveriesDao;
import pl.sowinski.Dao.SuppliersDao;
import pl.sowinski.domain.Deliveries;
import pl.sowinski.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/app/add/deliveries")
public class DeliveriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        int packaging = Integer.parseInt(request.getParameter("packaging"));
        String description = request.getParameter("description");
        int suppliers = Integer.parseInt(request.getParameter("suppliersId"));

        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("userName");

        Deliveries deliveries = new Deliveries();
        deliveries.setDate(date);
        deliveries.setStart(start);
        deliveries.setEnd(end);
        deliveries.setPackaging(packaging);
        deliveries.setDescription(description);
        deliveries.setUserId(user.getId());
        deliveries.setSuppliersId(suppliers);

        DeliveriesDao deliveriesDao = new DeliveriesDao();
        deliveriesDao.create(deliveries);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SuppliersDao suppliersDao = new SuppliersDao();

        request.setAttribute("suppliers", suppliersDao.readAll());
        getServletContext().getRequestDispatcher("/WEB-INF/deliveriesForm.jsp").forward(request, response);
    }
}

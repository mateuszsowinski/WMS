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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@WebServlet("/app/edit")
public class EditDeliveriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String date = request.getParameter("date");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        int packaging = Integer.parseInt(request.getParameter("packaging"));
        String description = request.getParameter("description");
        int suppliers = Integer.parseInt(request.getParameter("suppliersId"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("userName");

        Deliveries deliveries = new Deliveries();
        DeliveriesDao deliveriesDao = new DeliveriesDao();

        try {
            deliveries.setDate(simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        deliveries.setId(id);
        deliveries.setStart(start);
        deliveries.setEnd(end);
        deliveries.setPackaging(packaging);
        deliveries.setDescription(description);
        deliveries.setUserId(user.getId());
        deliveries.setSuppliersId(suppliers);
        deliveries.setLocalDateTime(LocalDateTime.now());

        deliveriesDao.edit(deliveries);
        response.sendRedirect(request.getContextPath() +"/app/landing");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        DeliveriesDao deliveriesDao = new DeliveriesDao();
        Deliveries deliveries = deliveriesDao.readById(id);
        SuppliersDao suppliersDao = new SuppliersDao();

        request.setAttribute("suppliers", suppliersDao.readAll());
        request.setAttribute("edit", deliveries);

        getServletContext().getRequestDispatcher("/WEB-INF/editDeliveriesForm.jsp").forward(request,response);
    }
}

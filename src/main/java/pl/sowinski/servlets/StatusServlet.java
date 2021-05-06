package pl.sowinski.servlets;

import pl.sowinski.Dao.DeliveriesDao;
import pl.sowinski.Dao.StatusDao;
import pl.sowinski.domain.Deliveries;
import pl.sowinski.domain.Status;
import pl.sowinski.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/app/status")
public class StatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userName");

        StatusDao statusDao = new StatusDao();
        Status status = new Status();
        status.setDateStatus(LocalDateTime.now());
        status.setStatus(1);
        status.setUserId(user.getId());
        status.setDeliveryId(id);

        statusDao.create(status);
        request.setAttribute("status", status);
        getServletContext().getRequestDispatcher("/app/landing").forward(request, response);

    }
}

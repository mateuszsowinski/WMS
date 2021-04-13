package pl.sowinski.servlets;

import pl.sowinski.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("")
public class LandingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("userName");

        if(user != null){
            response.sendRedirect("/app/landing");
        }else{
            response.sendRedirect("/login");
        }
    }
}

//
// if(user != null){
//         HttpSession httpSession = request.getSession();
//         httpSession.setAttribute("userName", user);
//         response.sendRedirect("/app/landing");
//         }else{
//         response.sendRedirect("/login");
//         }
//         } catch (Exception e) {
//         e.printStackTrace();
//         }
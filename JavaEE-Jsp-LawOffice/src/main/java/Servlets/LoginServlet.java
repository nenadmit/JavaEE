package Servlets;

import Utility.Authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("message",request.getParameter("message"));
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Authentication authentication = new Authentication();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String str = authentication.authenticate(username,password);

        if(!(str.equals("Success"))){
            request.setAttribute("message",str);
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("username" , username);

        response.sendRedirect("addCourtSession");


    }
}

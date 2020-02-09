package Servlets;


import Model.LawCases;
import Utility.PersistenceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
   public class DeleteServlet extends HttpServlet {

        private PersistenceUtils util = new PersistenceUtils("law");


        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {


            int id = Integer.valueOf(request.getParameter("id"));


            LawCases lawCase = util.findById(id);
            System.out.println(lawCase);
            request.setAttribute("warning",lawCase.toString() + " is sucessfuly Deleted!");


            util.deleteById(id);


            request.getRequestDispatcher("WEB-INF/views/searchByDate.jsp").forward(request,response);
        }



    }
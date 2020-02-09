package Servlets;


import Model.LawCases;
import Utility.PersistenceUtils;
import Utility.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet
public class AddServlet extends HttpServlet {

    public PersistenceUtils persistenceUtils;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {


        req.getRequestDispatcher("/WEB-INF/views/addCourtSession.jsp").forward(req,res);

      }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {


        System.out.println(req.getParameter("date"));

        PersistenceUtils persistenceUtils = new PersistenceUtils("law");
        LawCases lawCase = new LawCases();
        lawCase.setRegNumber(req.getParameter("regNumber"));
        lawCase.setCourt(req.getParameter("court"));

        var date = new DateConverter().convert(req.getParameter("date"));

        lawCase.setDate(date);

        lawCase.setTime(req.getParameter("time").substring(0,4));
        lawCase.setAditionalInfo(req.getParameter("aditionalInfo"));
        lawCase.setCourtRoom(req.getParameter("courtRoom"));
        lawCase.setClient(req.getParameter("client"));
        lawCase.setAgainst(req.getParameter("against"));



        persistenceUtils.save(lawCase);

        System.out.println(lawCase);

        req.setAttribute("sucessfull","Sucessfully Added!");

        req.getRequestDispatcher("/WEB-INF/views/addCourtSession.jsp").forward(req,res);

    }


}

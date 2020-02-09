package Servlets;

import Model.Files;
import Utility.PersistenceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


@WebServlet
public class FindFilesServlet extends HttpServlet {

    private PersistenceUtils persistenceUtils = new PersistenceUtils("file");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            Integer id;
        try{
            id = Integer.valueOf(request.getParameter("id"));
        }catch (NumberFormatException e){
            request.setAttribute("messageTwo","Search filed cannot be empty!");
            request.getRequestDispatcher("WEB-INF/views/upload.jsp").forward(request,response);
            return;
        }


        Files file = persistenceUtils.findFilesById(id);

        response.setContentType(file.getExtension());
        response.setHeader("Content-disposition","attachment; filename=" + file.getName());

        File dlFile = new File(file.getPath()+file.getName());

        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(dlFile);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
    }






    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        var arr =  persistenceUtils.searchFilesByName(request.getParameter("name"));
        request.setAttribute("arr",arr);



        request.getRequestDispatcher("WEB-INF/views/upload.jsp").forward(request,response);



    }







}

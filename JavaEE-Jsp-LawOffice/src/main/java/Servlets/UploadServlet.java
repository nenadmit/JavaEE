package Servlets;

import Model.Files;
import Utility.PersistenceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Calendar;

@MultipartConfig
@WebServlet(urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {

    private PersistenceUtils persistenceUtils = new PersistenceUtils("file");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        req.getRequestDispatcher("WEB-INF/views/upload.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Calendar c = Calendar.getInstance();

        String path = getInitParameter("fileLocation");
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);



        OutputStream outStr = null;
        InputStream filecontent = null;


        try {
            outStr = new FileOutputStream(new File(path + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;

            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                outStr.write(bytes, 0, read);


            }
            Files file = new Files();
            file.setName(fileName);
            file.setPath(path);
            file.setExtension(getFileExtension(fileName));
            file.setLastModified(c.getTime().toString());
            persistenceUtils.save(file);



            request.setAttribute("message", "File sucessfuly uploaded!");

        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "Please select the file for upload!");


        } finally {
            if (outStr != null) {
                outStr.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }


        }

        request.getRequestDispatcher("WEB-INF/views/upload.jsp").forward(request, response);


    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String getFileExtension(String fileName) {

        String[] arr = fileName.split("\\.");


        return "." + arr[arr.length - 1];
    }
}

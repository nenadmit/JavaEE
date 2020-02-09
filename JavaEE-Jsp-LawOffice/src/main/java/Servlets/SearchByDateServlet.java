package Servlets;

import Model.LawCases;
import Utility.PersistenceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@WebServlet
public class SearchByDateServlet extends HttpServlet {

    public PersistenceUtils persistenceUtils = new PersistenceUtils("law");
    private String warningMsg = "";


    private Map<String, List<LawCases>> dateMap = new LinkedHashMap<>();

    private Date firstDate;
    private Date secondDate;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        request.setAttribute("arr", dateMap);
        request.setAttribute("warning", warningMsg);

        request.getRequestDispatcher("WEB-INF/views/searchByDate.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {




        if (request.getParameter("startDate").equals("") ||
                request.getParameter("secondDate").equals("")) {
            this.warningMsg = "Please input dates!";
            response.sendRedirect("searchByDate");
            return;
        }

        this.dateMap.clear();

        Calendar c = Calendar.getInstance();


        this.warningMsg = "";

        try {
            firstDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
            secondDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("secondDate"));
        } catch (ParseException e) {

            // It wont throw Parse Exception since it takes input from html <date input> form
            e.printStackTrace();

        }

        populateHashMap(firstDate,secondDate);

        request.setAttribute("arr", dateMap);
        request.setAttribute("firstDate",firstDate.toString());
        request.setAttribute("secondDate",secondDate.toString());

        request.getRequestDispatcher("WEB-INF/views/searchByDate.jsp").forward(request,response);

    }

    //Returns week days as a String, since variable Calendar.DAY_OF_WEEK is an int
    public String daysOfWeek(int i) {

        switch (i) {
            case 1:
                return "Saturday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Sunday";

        }
        return "";
    }


    // Returns a difference in days between first and second date
    public long getDateDifference(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }



    public void populateHashMap(Date firstDate,Date secondDate){



        Calendar c = Calendar.getInstance();

        Date today = c.getTime();

        // Uses a method to check for a difference between date of today and the first date input
        long diffTodayAndFirstDate = getDateDifference(today,firstDate,TimeUnit.DAYS);

        // Difference between first and second date inputs
        long diffBetweenInputDates = getDateDifference(firstDate,secondDate,TimeUnit.DAYS);


        //Calendar starts from the day of the first date input
        c.add(Calendar.DATE,(int) diffTodayAndFirstDate);



        //Number of iterations depend on the difference between first and second date inputs
        for(int x= 0;x<(int) diffBetweenInputDates;x++){


            // Adds +1 day to the calendar in each iteration
            c.add(Calendar.DATE,1);

            //returns a List of LawCases from the database with same date
            List<LawCases> listOfCases = persistenceUtils.findByDate(c.getTime());

            if(listOfCases.isEmpty()){
                LawCases emptyList = new LawCases();
                emptyList.setAditionalInfo("NO COURT SESSIONS TODAY");
                listOfCases.add(emptyList);
            }


            String dayOfWeek = daysOfWeek(c.get(Calendar.DAY_OF_WEEK)) + " - " +
                    new SimpleDateFormat("dd-MM-yyyy").format(c.getTime());


            dateMap.put(dayOfWeek,listOfCases);

        }
    }
    public Map<String, List<LawCases>> getDateMap() {
        return dateMap;
    }

    public void setDateMap(Map<String, List<LawCases>> dateMap) {
        this.dateMap = dateMap;
    }




}

package Utility;

import Model.LawCases;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Random;

@WebServlet
public class PopulateDb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response){

        PersistenceUtils util = new PersistenceUtils("law");
        Calendar c = Calendar.getInstance();
        LawCases lawCase;

        String[] courts = {"OS Nis","OS Bgd","OS Zajecar","OS Novi Sad","VS LE","APS Nis","APS Bgd"};
        String[] regNumbers={"P.123/19","K.24/10","P1.99/19","Gz.120/18","II.192/19","P.19493/19","Kt.294/12"};
        String[] clients={"kombank","efg","microsoft","apple","marfin","Samsung","huaweei"};
        String[] courtRooms = {"102","123/A","19","334","44/A","65-B","92-1"};


        int counterOne=1;

        Random random = new Random();

        for (int x =0;x<250;x++){
            lawCase = new LawCases();
            lawCase.setCourt(courts[random.nextInt(7)]);
            lawCase.setRegNumber(regNumbers[random.nextInt(7)]);
            lawCase.setClient(clients[random.nextInt(7)]);
            lawCase.setAgainst(clients[random.nextInt(7)]);
            lawCase.setCourtRoom(courtRooms[random.nextInt(7)]);
            lawCase.setDate(new DateConverter().convert(c.getTime()));
            lawCase.setTime("11:00:00");
            lawCase.setAditionalInfo("info here");
            util.save(lawCase);
            counterOne++;
            if(counterOne%7 == 0){
                c.add(Calendar.DATE,1);
            }

        }

    }
}

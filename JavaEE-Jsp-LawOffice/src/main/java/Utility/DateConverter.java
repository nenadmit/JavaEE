package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {




    public DateConverter(){

    }

    public java.sql.Date convert(String str) {

        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.getErrorOffset();
        }

        return new java.sql.Date(date.getTime());

    }
    public java.sql.Date convert(Date date){
        return new java.sql.Date(date.getTime());

    }



}

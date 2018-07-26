package com.jams.itsolution.demoweather.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Const {
    public static final String API_KEY = "2070cdca105d4f5c913122559181807";
    public static final String BASE_URL = "http://api.apixu.com/v1/";
    public static final String CITY = "Bangalore";
    public static final int DALY = 5;


    public static String ConvertDateToFormat(String input_date){

        String dateStr="";
        try {
            DateFormat input_date_format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            DateFormat final_format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date dateLast = input_date_format.parse(input_date);
            String dateLast1 = final_format.format(dateLast);
            Date objDate = new Date();

            String dateLast2 =final_format.format(objDate);
            Calendar c = Calendar.getInstance();
            c.setTime(objDate);
            c.add(Calendar.DATE, 1);
            String dateLast3 =final_format.format(c.getTime());

            if(dateLast1.equals(dateLast2)){
                dateStr = "Today";
            }else if(dateLast1.equals(dateLast3)){
                dateStr = "Tomorrow";
            }else {
                dateStr = dateLast1;

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateStr;
    }

}

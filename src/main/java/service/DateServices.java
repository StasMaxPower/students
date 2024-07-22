package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateServices {

    public static String convertDateForDB(String date) {
        String dateForDb;
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date formattedDate = format.parse(date);
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2021-09-01 01:00:00.000
            dateForDb = formatter.format(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка форматирования даты!");
        }
        return dateForDb;
    }

}

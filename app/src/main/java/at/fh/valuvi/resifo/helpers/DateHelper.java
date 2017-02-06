package at.fh.valuvi.resifo.helpers;

import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public static String getDisplayDate(Date date) {
        if (date == null) { return null; }

        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");

        return fmt.format(date);
    }

    public static void setDatePickerDate(DatePicker datePicker, Date date) {
        if (date == null) { return; }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        datePicker.updateDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
    }

    public static Date getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    public static Date getDateFromDbDateString(String string) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string);
    }

    public static String getDbDateString(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

        return fmt.format(date);
    }

    public static String getDbDateTimeString(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return fmt.format(date);
    }

}

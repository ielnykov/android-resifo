package at.fh.valuvi.resifo.helpers;

import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public static String getDisplayDate(Date date) {
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

}

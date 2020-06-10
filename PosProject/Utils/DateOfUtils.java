package PosProject.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateOfUtils {

    public String getToday() {          // 년월일만 가져오기
        long time = System.currentTimeMillis();

        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");

        String str = dayTime.format(new Date(time));

        return str;
    }

    public String getToDate() {         // 초를 제외한 시간까지 함께 가져오기
        long time = System.currentTimeMillis();

        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String str = dayTime.format(new Date(time));

        return str;
    }

    public String getMonth() {          // 해당 달만 가져오기
        long time = System.currentTimeMillis();

        SimpleDateFormat dayTime = new SimpleDateFormat("MM");

        String str = dayTime.format(new Date(time));

        return str;
    }

    public String wantToDate(int year, int month, int day, int hour, int minute) {
        Calendar calendar =  Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, day);

        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);

        String toYear = Integer.toString(year);
        String toMonth = Integer.toString(month);
        String toDay = Integer.toString(day);
        String toHour = Integer.toString(hour);
        String toMinute = Integer.toString(minute);

        if (month < 10) {
            toMonth = "0"+ toMonth;
        }

        if (day < 10) {
            toDay = "0"+ toDay;
        }

        if (hour < 10) {
            System.out.println(calendar.get(Calendar.HOUR));
            toHour = "0"+ toHour;
        }

        if (minute < 10) {
            toMinute = "0"+ toMinute;
        }

        String data = toYear +"-"+ toMonth + "-" + toDay + " " + toHour + ":" + toMinute;
        
        return data;
    }

    public String wantToDay(int year, int month, int day) {
        Calendar calendar =  Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, day);

        String toYear = Integer.toString(year);
        String toMonth = Integer.toString(month);
        String toDay = Integer.toString(day);

        if (month < 10) {
            toMonth = "0"+ toMonth;
        }

        if (day < 10) {
            toDay = "0"+ toDay;
        }

        String data = toYear +"-"+ toMonth + "-" + toDay;
        
        return data;
    }
}
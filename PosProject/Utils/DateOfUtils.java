package PosProject.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOfUtils {

    public String getToday() {
        long time = System.currentTimeMillis();

        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String str = dayTime.format(new Date(time));

        int idx = str.indexOf(" ");

        return str.substring(0, idx);
    }

    public String getToDate() {
        long time = System.currentTimeMillis();

        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String str = dayTime.format(new Date(time));

        return str;
    }

    public String getMonth() {
        long time = System.currentTimeMillis();

        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String str = dayTime.format(new Date(time));

        int idx = str.indexOf(" ");

        String day = str.substring(0, idx);

        String[] data = day.split("-");

        return data[1];
    }
}
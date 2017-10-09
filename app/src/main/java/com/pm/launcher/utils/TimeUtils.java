package com.pm.launcher.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by jinghao on 2017/10/9.
 */

public class TimeUtils {

    public static String get_am_or_pm() {
        GregorianCalendar ca = new GregorianCalendar();
        int state = ca.get(GregorianCalendar.AM_PM);
        if (state == 0) {
            return "am";
        } else if (state == 1) {
            return "pm";
        } else {
            LogMgr.e("判断时间是am还是pm出错");
        }
        return "am";
    }

    public static String getDate() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return mDateFormat.format(date);
    }

    public static String getDay() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat mDateFormat = new SimpleDateFormat("EEEE");
        return mDateFormat.format(date);
    }

    public static String getHour() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat mDateFormat = new SimpleDateFormat("hh");
        return mDateFormat.format(date);
    }

    public static String getMin() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat mDateFormat = new SimpleDateFormat("mm");
        return mDateFormat.format(date);
    }

}

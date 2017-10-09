package com.pm.launcher.model;

/**
 * Created by user on 2017/10/9.
 */

public class TimeInfoBean {

    private String hour;
    private  String min;
    private String pm;
    private String day;
    private String date;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "hour:"+hour+"       min:"+min+"     pm:"+pm+"       day:"+day+"     date:"+date;
    }
}

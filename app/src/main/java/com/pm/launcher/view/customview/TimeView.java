package com.pm.launcher.view.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pm.launcher.R;

import org.w3c.dom.Text;


/**
 * Created by jinghao on 2017/10/8.
 */

public class TimeView extends LinearLayout {

    private TextView tv_hour;
    private TextView tv_min;
    private TextView tv_pm;
    private TextView tv_day;
    private TextView tv_date;

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initTimeView(context);
    }

    public void initTimeView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.time_view, this);
        tv_hour = (TextView) findViewById(R.id.tv_home_time_hour);
        tv_min = (TextView) findViewById(R.id.tv_home_time_min);
        tv_pm = (TextView) findViewById(R.id.tv_home_time_pm);
        tv_day = (TextView) findViewById(R.id.tv_home_time_day);
        tv_date = (TextView) findViewById(R.id.tv_home_time_date);
    }

    public void setHour(String h){
        tv_hour.setText(h);
        invalidate();
    }

    public void setMin(String m){
        tv_min.setText(m);
        invalidate();
    }

    public void setPm(String p){
        tv_pm.setText(p);
        invalidate();
    }

    public void setDay(String d){
        tv_day.setText(d);
        invalidate();
    }

    public void setDate(String d){
        tv_date.setText(d);
        invalidate();
    }

}

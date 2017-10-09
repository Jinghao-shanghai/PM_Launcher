package com.pm.launcher.view.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pm.launcher.R;
import com.pm.launcher.utils.LogMgr;

import org.w3c.dom.Text;


/**
 *  天气显示控件
 * Created by user on 2017/9/30.
 */

public class WheatherView extends RelativeLayout {
    private TextView tv_temperature;
    private TextView tv_weather;
    private ImageView iv_weather;


    public WheatherView(Context context,AttributeSet attrs){
        super(context,attrs);
        initWeatherView(context);
    }


    public void initWeatherView(Context context){
        LogMgr.d("init WeatherView!");
        LayoutInflater.from(context).inflate(R.layout.weather_view, this);
        tv_temperature=(TextView)findViewById(R.id.tv_home_weatherview_temperature);
        tv_weather=(TextView)findViewById(R.id.tv_home_weatherview_weather);
        iv_weather=(ImageView)findViewById(R.id.iv_home_weatherview_temperature);
    }

    public  void setTemperature(String t){
        tv_temperature.setText(t);
        invalidate();
    }

    public void setWeather(String w){
        tv_weather.setText(w);
        invalidate();
    }

    public void setWeatherImg(int id){
        iv_weather.setImageResource(id);
        invalidate();
    }

}

package com.pm.launcher.service;

import com.pm.launcher.model.TimeInfoBean;
import com.pm.launcher.model.WeatherInfoBean;
import com.pm.launcher.utils.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;

/**
 * Created by jinghao on 2017/10/9.
 */

public class QueryService {

    private static QueryService instance;

    private QueryService() {

    }

    public static QueryService getInstance() {
        if (instance == null) {
            synchronized (QueryService.class) {
                if (instance == null) {
                    instance = new QueryService();
                }
            }
        }
        return instance;
    }

    public WeatherInfoBean queryWeatherInfo() {
        OkHttpClient mOKHttpClient=new OkHttpClient();
        mOKHttpClient.
        return null;
    }

    public TimeInfoBean queryTimeInfo() {
        TimeInfoBean mTimeInfoBean = new TimeInfoBean();
        mTimeInfoBean.setHour(TimeUtils.getHour());
        mTimeInfoBean.setMin(TimeUtils.getMin());
        mTimeInfoBean.setDate(TimeUtils.getDate());
        mTimeInfoBean.setDay(TimeUtils.getDay());
        mTimeInfoBean.setPm(TimeUtils.get_am_or_pm());
        return mTimeInfoBean;
    }

}

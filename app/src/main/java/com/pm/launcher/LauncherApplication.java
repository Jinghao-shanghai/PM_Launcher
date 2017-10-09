package com.pm.launcher;

import android.app.Activity;

import com.pm.launcher.utils.LogMgr;

import org.litepal.LitePalApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinghao on 2017/9/30.
 */

public class LauncherApplication extends LitePalApplication {
    public static LauncherApplication instance;
    private List<Activity> mActivityList=new ArrayList<Activity>();
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public void  addToList(Activity activity){
        mActivityList.add(activity);
    }

    public void exit(){
        for(Activity activity:mActivityList){
            activity.finish();
        }
        LogMgr.e("退出应用");
    }
}

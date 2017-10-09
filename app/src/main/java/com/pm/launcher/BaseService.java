package com.pm.launcher;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.pm.launcher.utils.LogMgr;

/**
 * Created by Raytine on 2017/10/6.
 */

public class BaseService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogMgr.d("onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogMgr.d("onCreate");
    }
}

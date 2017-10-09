package com.pm.launcher.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.pm.launcher.BaseService;
import com.pm.launcher.R;
import com.pm.launcher.utils.LogMgr;
import com.pm.launcher.view.customview.StateBarItemInfo;
import com.pm.launcher.view.customview.StateBarView;

/**
 * Created by jinghao on 2017/10/5.
 */

public class StateBarService extends BaseService {
    private WindowManager mWMgr;
    private StateBarView mStateBarView;
    private final static String ACTION_STATE_BAR_ = "action_state_bar";
    private final static String STATE_BAR_VIEW_TYPE = "state_bar_view_type";
    private final static String STATE_BAR_VIEW_STATE= "state_bar_view_type";
    private final static String STATE_BAR_DATA = "state_bar_data";
    private final static String STATE_BAR_VIEW_TYPE_WIFI = "wifi";
    private final static String STATE_BAR__WIFI_CONNECTED = "wifi_connected";
    private final static String STATE_BAR__WIFI_NOT_CONNECTED = "wifi_not_connected";
    private final static String STATE_BAR_VIEW_TYPE_SOUND = "sound";
    private final static String STATE_BAR_SOUND_SILENT = "silent";
    private final static String STATE_BAR_SOUND_NOT_SILENT = "not_silent";
    private final static String STATE_BAR_VIEW_TYPE_CALL = "call";
    private final static String STATE_BAR_CALL = "call_record";
    private final static String STATE_BAR_NO_CALL = "no_call_record";
    private final static String STATE_BAR_VIEW_TYPE_MSG = "msg";
    private final static String STATE_BAR_MSG = "msg";
    private final static String STATE_BAR_NO_MSG = "no_msg";
    private final static String STATE_BAR_VIEW_TYPE_MODE = "mode";
    private final static String STATE_BAR_HOME_MODE = "home_mode";
    private final static String STATE_BAR_OUT_MODE = "out_mode";
    private final static String STATE_BAR_VIEW_TYPE_ALARM = "alarm";
    private final static String STATE_BAR_ALARM = "alarm";
    private final static String STATE_BAR_NO_ALARM = "no_alarm";
    private final static String STATE_BAR_VIEW_TYPE_CONNECTION = "connection";
    private final static String STATE_BAR_CONNECTED = "connected";
    private final static String STATE_BAR_NOT_CONNECTED = "not_connected";
    private final static String STATE_BAR_VIEW_TYPE_BATTERY = "battery";
    private final static String STATE_BAR_H_BATTERY = "h_battery";
    private final static String STATE_BAR_L_BATTERY = "l_battery";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mWMgr = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        createStateView();
        mStateBarView.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mWMgr.addView(mStateBarView, getStatusBarLayoutParams(mStateBarView.getMeasuredHeight()));
        registerStateBarBroadcast();
        LogMgr.d("add view<===");
    }

    private void createStateView() {
        LogMgr.d("create state view===>");
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup v = (ViewGroup) mInflater.inflate(R.layout.statebar_view, null);
        if (v instanceof StateBarView) {
            mStateBarView = (StateBarView) v;
        } else {
            mStateBarView = new StateBarView(this);
        }
    }

    private void initStatusBarInfo() {


    }

    private void refreshStateView(Intent infoIntent) {

    }

    private void registerStateBarBroadcast() {
        IntentFilter stateBarFilter = new IntentFilter(ACTION_STATE_BAR_);
        registerReceiver(mStateBarReceiver, stateBarFilter);
    }


    private WindowManager.LayoutParams getStatusBarLayoutParams(int statusBarHieght) {
        LogMgr.d("get StatusBarLayoutParams===>");
        WindowManager.LayoutParams wlp = new WindowManager.LayoutParams();

        wlp.format = PixelFormat.TRANSPARENT;

        wlp.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;

        wlp.x = 0;
        wlp.y = 0;

        wlp.height = statusBarHieght;
        wlp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wlp.type = WindowManager.LayoutParams.TYPE_PHONE;
        wlp.gravity = getStatusBarGravity();
        return wlp;
    }

    private int getStatusBarGravity() {
        LogMgr.d("getStatusBarGravity===>");
        return Gravity.LEFT | Gravity.TOP;
    }


    private BroadcastReceiver mStateBarReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle stateBarData=intent.getBundleExtra(STATE_BAR_DATA);
            LogMgr.d("receive broadcast to refresh state bar");
            switch ((String)stateBarData.get(STATE_BAR_VIEW_TYPE)) {
                case STATE_BAR_VIEW_TYPE_WIFI:
                    StateBarItemInfo item_wifi=new StateBarItemInfo();
                    String state_wifi=stateBarData.getString(STATE_BAR_VIEW_STATE);
                    if (state_wifi.equals(STATE_BAR__WIFI_CONNECTED)){
                        item_wifi.setGone(true);
                        item_wifi.setImgSourceId(R.drawable.wifi_state);
                    }
                    mStateBarView.setWifiView(item_wifi);
                    break;

                case STATE_BAR_VIEW_TYPE_SOUND:
                    StateBarItemInfo item_sound=new StateBarItemInfo();
                    String state_sound=stateBarData.getString(STATE_BAR_VIEW_STATE);
                    if (state_sound.equals(STATE_BAR_SOUND_SILENT)){
                        item_sound.setGone(true);
                        item_sound.setImgSourceId(R.drawable.wifi_state);
                    }
                    mStateBarView.setSoundView(item_sound);
                    break;

                case STATE_BAR_VIEW_TYPE_CALL:
                    StateBarItemInfo item_call=new StateBarItemInfo();
                    String state_call=stateBarData.getString(STATE_BAR_VIEW_STATE);
                    if (state_call.equals(STATE_BAR_SOUND_SILENT)){
                        item_call.setGone(true);
                        item_call.setImgSourceId(R.drawable.call_record);
                    }
                    mStateBarView.setCallRecordView(item_call);
                    break;

                case STATE_BAR_VIEW_TYPE_MSG:

                    break;

                case STATE_BAR_VIEW_TYPE_MODE:

                    break;

                case STATE_BAR_VIEW_TYPE_ALARM:
                    StateBarItemInfo item_alarm=new StateBarItemInfo();
                    String state_alarm=stateBarData.getString(STATE_BAR_VIEW_STATE);
                    if (state_alarm.equals(STATE_BAR_SOUND_SILENT)){
                        item_alarm.setGone(true);
                        item_alarm.setImgSourceId(R.drawable.wifi_state);
                    }
                    mStateBarView.setAlarmView(item_alarm);
                    break;

                case STATE_BAR_VIEW_TYPE_CONNECTION:

                    break;

                case STATE_BAR_VIEW_TYPE_BATTERY:

                    break;
            }
        }
    };
}

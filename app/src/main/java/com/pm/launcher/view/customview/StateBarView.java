package com.pm.launcher.view.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pm.launcher.R;
import com.pm.launcher.utils.LogMgr;

import java.util.ArrayList;

/**
 * Created by jinghao on 2017/10/5.
 */

public class StateBarView extends RelativeLayout {
    private ImageView iv_state_1;
    private ImageView iv_state_2;
    private ImageView iv_state_3;
    private ImageView iv_state_4;
    private ImageView iv_state_5;
    private ImageView iv_state_6;
    private ImageView iv_state_7;
    private ImageView iv_state_8;


    public StateBarView(Context context) {
        super(context);
        initStateBarView(context);
    }

    public StateBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initStateBarView(Context context) {
        LogMgr.d("init StateBarView!");
        LayoutInflater.from(context).inflate(R.layout.statebar_view, this);
        iv_state_1 = (ImageView) findViewById(R.id.iv_state_bar1);
        iv_state_1.setVisibility(View.GONE);
        iv_state_2 = (ImageView) findViewById(R.id.iv_state_bar2);
        iv_state_3 = (ImageView) findViewById(R.id.iv_state_bar3);
        iv_state_3.setVisibility(View.GONE);
        iv_state_4 = (ImageView) findViewById(R.id.iv_state_bar4);
        iv_state_5 = (ImageView) findViewById(R.id.iv_state_bar5);
        iv_state_6 = (ImageView) findViewById(R.id.iv_state_bar6);
        iv_state_6.setVisibility(View.GONE);
        iv_state_7 = (ImageView) findViewById(R.id.iv_state_bar7);
        iv_state_8 = (ImageView) findViewById(R.id.iv_state_bar8);
    }

    public void setWifiView(StateBarItemInfo itemInfo) {
        if (!itemInfo.isGone()) {
            iv_state_1.setImageResource(itemInfo.getImgSourceId());
        } else {
            iv_state_1.setVisibility(View.GONE);
        }
    }

    public void setSoundView(StateBarItemInfo itemInfo) {
        if (!itemInfo.isGone()) {
            iv_state_2.setImageResource(itemInfo.getImgSourceId());
        } else {
            iv_state_2.setVisibility(View.GONE);
        }
    }

    public void setCallRecordView(StateBarItemInfo itemInfo) {
        if (!itemInfo.isGone()) {
            iv_state_3.setImageResource(itemInfo.getImgSourceId());
        } else {
            iv_state_3.setVisibility(View.GONE);
        }
    }

    public void setMsgView(StateBarItemInfo itemInfo) {
        if (!itemInfo.isGone()) {
            iv_state_4.setImageResource(itemInfo.getImgSourceId());
        } else {
            iv_state_4.setVisibility(View.GONE);
        }
    }

    public void setModeView(StateBarItemInfo itemInfo) {
        if (!itemInfo.isGone()) {
            iv_state_5.setImageResource(itemInfo.getImgSourceId());
        } else {
            iv_state_5.setVisibility(View.GONE);
        }
    }

    public void setAlarmView(StateBarItemInfo itemInfo) {
        if (!itemInfo.isGone()) {
            iv_state_6.setImageResource(itemInfo.getImgSourceId());
        } else {
            iv_state_6.setVisibility(View.GONE);
        }
    }

    public void setConnectionView(StateBarItemInfo itemInfo) {
        if (!itemInfo.isGone()) {
            iv_state_7.setImageResource(itemInfo.getImgSourceId());
        } else {
            iv_state_7.setVisibility(View.GONE);
        }
    }

    public void setBatteryView(StateBarItemInfo itemInfo) {
        if (!itemInfo.isGone()) {
            iv_state_8.setImageResource(itemInfo.getImgSourceId());
        } else {
            iv_state_8.setVisibility(View.GONE);
        }
    }

    public  void updateView(){
        invalidate();
    }

}

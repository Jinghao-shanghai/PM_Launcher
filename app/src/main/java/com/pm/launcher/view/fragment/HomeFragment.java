package com.pm.launcher.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pm.launcher.BaseFragment;
import com.pm.launcher.R;
import com.pm.launcher.model.TimeInfoBean;
import com.pm.launcher.service.QueryService;
import com.pm.launcher.utils.LogMgr;
import com.pm.launcher.view.activity.MonitorActivity;
import com.pm.launcher.view.activity.TalkActivity;
import com.pm.launcher.view.adapter.AdViewPagerAdapter;
import com.pm.launcher.view.customview.TimeView;
import com.pm.launcher.view.customview.WheatherView;

import java.util.ArrayList;

/**
 * 首页界面
 * Created by jinghao on 2017/10/9.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private WheatherView mWheatherView;
    private TimeView mTimeView;
    private RelativeLayout mTalk;
    private RelativeLayout mMonitor;
    private RelativeLayout mElecLiftControl;
    private RelativeLayout mMessage;
    private RelativeLayout mApps;
    private RelativeLayout mSetting;
    private ViewPager mAd;
    private AdViewPagerAdapter mViewPagerAdapter;
    private ArrayList<ImageView> mImageViews;
    private TimeInfoBean mTimeInfoBean;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);
        initView(v);
        return v;
    }

    private void initView(View v){
        mWheatherView = v.findViewById(R.id.weatherview_home);
        mTimeView = v.findViewById(R.id.timeview_home);
        mTimeInfoBean= QueryService.getInstance().queryTimeInfo();
        LogMgr.d("timeInfo:"+mTimeInfoBean.toString());
        mTimeView.setHour(mTimeInfoBean.getHour());
        mTimeView.setMin(mTimeInfoBean.getMin());
        mTimeView.setDay(mTimeInfoBean.getDay());
        mTimeView.setDate(mTimeInfoBean.getDate());
        mTimeView.setPm(mTimeInfoBean.getPm());
        mTalk = v.findViewById(R.id.rl_home_talk);
        mTalk.setOnClickListener(this);
        mMonitor = v.findViewById(R.id.rl_home_monitor);
        mMonitor.setOnClickListener(this);
        mElecLiftControl = v.findViewById(R.id.rl_home_electric_lift_control);
        mElecLiftControl.setOnClickListener(this);
        mMessage = v.findViewById(R.id.rl_home_message);
        mMessage.setOnClickListener(this);
        mApps = v.findViewById(R.id.rl_home_apps);
        mApps.setOnClickListener(this);
        mSetting = v.findViewById(R.id.rl_home_setting);
        mSetting.setOnClickListener(this);
        mAd = v.findViewById(R.id.vp_home_ad);
        ImageView ad1=new ImageView(getContext());
        ad1.setImageResource(R.drawable.ad1);
        ImageView ad2=new ImageView(getContext());
        ad2.setImageResource(R.drawable.ad2);
        mImageViews=new ArrayList<ImageView>();
        mImageViews.add(ad1);
        mImageViews.add(ad2);
        mViewPagerAdapter=new AdViewPagerAdapter(mImageViews);
        mAd.setAdapter(mViewPagerAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_home_talk:
                startInternalActivity(TalkActivity.class);
                break;
            case R.id.rl_home_monitor:
                startInternalActivity(MonitorActivity.class);
                break;
            case R.id.rl_home_electric_lift_control:
                break;
            case R.id.rl_home_message:
                break;
            case R.id.rl_home_apps:
                break;
            case R.id.rl_home_setting:
                startOutActivity("com.pm.setting","com.pm.setting.MainActivity");
                break;
            default:
                break;
        }
    }
}

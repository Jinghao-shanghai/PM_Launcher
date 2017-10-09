package com.pm.launcher.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pm.launcher.BaseFragment;
import com.pm.launcher.R;

/**
 * 首页左界面
 * Created by jinghao on 2017/10/9.
 */

public class LeftFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frament_left,null);
        return v;
    }
}

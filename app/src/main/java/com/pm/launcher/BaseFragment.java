package com.pm.launcher;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by jinghao on 2017/10/9.
 */

public class BaseFragment extends Fragment{

    protected  void startInternalActivity(Class targetClass){
        Intent i=new Intent(getContext(),targetClass);
        startActivity(i);
    }

    protected  void startOutActivity(String packageName,String targetActivity){
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(packageName, targetActivity);
        startActivity(intent);
    }
}

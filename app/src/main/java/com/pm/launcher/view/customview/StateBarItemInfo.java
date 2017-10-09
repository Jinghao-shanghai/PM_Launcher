package com.pm.launcher.view.customview;

/**
 * Created by Raytine on 2017/10/7.
 */

public class StateBarItemInfo {
    //图标类型
    private String type;
    //图标是否显示
    private boolean isGone;
    //图标显示状态
    private int state;
    //图标图片资源id
    private int imgSourceId;
    //位置id
    private int positionId;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isGone() {
        return isGone;
    }

    public void setGone(boolean gone) {
        isGone = gone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getImgSourceId() {
        return imgSourceId;
    }

    public void setImgSourceId(int imgSourceId) {
        this.imgSourceId = imgSourceId;
    }

}

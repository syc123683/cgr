package com.sudao.cloud.module.entity;

import com.sudao.cloud.module.entity.base.Entity;

/**
 * Created by Spector on 2017/6/2.
 */
public class ActivityInfo extends Entity {
    private String activityName;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}

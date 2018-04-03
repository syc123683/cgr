package com.sudao.cloud.module.entity.base;

import java.util.Date;

/**
 * general
 * <p>
 * Description :
 * <p>
 * Creator :
 * Sudao @ Tim Zhang
 * Email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * Date: 2017/10/20
 * Time: 上午11:57
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/20 上午11:57
 */
public class BaseDTO {
    /******* Fields Area *******/
    private Integer displayOrder;

    private Integer version;

    private Integer deleted;

    private Long createUserId;

    private String createUserName;

    private Date createTime;

    private Long updateUserId;

    private String updateUserName;

    private Date updateTime;

    private Date lastUpdate;
    /******* Construction Area *******/
    public BaseDTO() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

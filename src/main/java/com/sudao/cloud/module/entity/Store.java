package com.sudao.cloud.module.entity;

/**
 * Created by Spector on 2017/6/2.
 */
public class Store {
    private Long id;
    private Long relationId;
    private Long storeName;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreName() {
        return storeName;
    }

    public void setStoreName(Long storeName) {
        this.storeName = storeName;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

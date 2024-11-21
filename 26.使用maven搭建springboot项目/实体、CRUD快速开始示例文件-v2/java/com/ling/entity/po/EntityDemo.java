package com.ling.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * demo实体
 */
public class EntityDemo {
    private String id;
    //    private Integer id;   // id为int时
    private String stringField;
    private Integer intField;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dateField;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


    public EntityDemo() {
    }

    public EntityDemo(String id, String stringField, Integer intField, Date dateField, Date createTime, Date updateTime) {
        this.id = id;
        this.stringField = stringField;
        this.intField = intField;
        this.dateField = dateField;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * 获取
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return stringField
     */
    public String getStringField() {
        return stringField;
    }

    /**
     * 设置
     *
     * @param stringField
     */
    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    /**
     * 获取
     *
     * @return intField
     */
    public Integer getIntField() {
        return intField;
    }

    /**
     * 设置
     *
     * @param intField
     */
    public void setIntField(Integer intField) {
        this.intField = intField;
    }

    /**
     * 获取
     *
     * @return dateField
     */
    public Date getDateField() {
        return dateField;
    }

    /**
     * 设置
     *
     * @param dateField
     */
    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }

    /**
     * 获取
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     *
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     *
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        return "EntityDemo{id = " + id + ", stringField = " + stringField + ", intField = " + intField + ", dateField = " + dateField + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
    }
}

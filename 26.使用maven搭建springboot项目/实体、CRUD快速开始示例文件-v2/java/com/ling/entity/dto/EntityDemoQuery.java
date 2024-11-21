package com.ling.entity.dto;

import java.util.Date;

/**
 * demo查询数据传输对象
 */
public class EntityDemoQuery extends BaseQueryParam {
    private String id;
    //    private Integer id;   // id为int时
    private String stringField;
    private Integer intField;
    private Date dateField;


    public EntityDemoQuery() {
    }

    public EntityDemoQuery(String id, String stringField, Integer intField, Date dateField) {
        this.id = id;
        this.stringField = stringField;
        this.intField = intField;
        this.dateField = dateField;
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

    public String toString() {
        return "EntityDemoParam{id = " + id + ", stringField = " + stringField + ", intField = " + intField + ", dateField = " + dateField + "}";
    }
}

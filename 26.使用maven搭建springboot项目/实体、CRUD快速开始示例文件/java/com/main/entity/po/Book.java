package com.main.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.main.entity.param.BusinessParam;

import java.util.Date;

public class Book extends BusinessParam<Book> {
    private Integer id;
    private String isbn;
    private String name;
    private String cover;
    private String author;
    private String publish;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date publishDate;
    private Integer bookTypeId;
    private String description;
    private Integer number;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book(Integer id, String name, String cover, String author, String publish, Date publishDate, Integer bookTypeId, String description, Integer number, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.author = author;
        this.publish = publish;
        this.publishDate = publishDate;
        this.bookTypeId = bookTypeId;
        this.description = description;
        this.number = number;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * 获取
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置
     *
     * @param cover
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     *
     * @return publish
     */
    public String getPublish() {
        return publish;
    }

    /**
     * 设置
     *
     * @param publish
     */
    public void setPublish(String publish) {
        this.publish = publish;
    }

    /**
     * 获取
     *
     * @return publishDate
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 设置
     *
     * @param publishDate
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取
     *
     * @return bookTypeId
     */
    public Integer getBookTypeId() {
        return bookTypeId;
    }

    /**
     * 设置
     *
     * @param bookTypeId
     */
    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    /**
     * 获取
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     *
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置
     *
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
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
        return "Book{id = " + id + ", name = " + name + ", cover = " + cover + ", author = " + author + ", publish = " + publish + ", publishDate = " + publishDate + ", bookTypeId = " + bookTypeId + ", description = " + description + ", number = " + number + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
    }
}

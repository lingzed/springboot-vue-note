package com.main.service;

import com.main.entity.po.Book;
import com.main.entity.vo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    /**
     * 查询
     *
     * @param book
     * @return
     */
    PageBean<Book> find(Book book);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Book findById(String id);

    /**
     * 添加
     *
     * @param book
     */
    void add(Book book);

    /**
     * 批量添加
     *
     * @param books
     */
    void batchAdd(@Param("books") List<Book> books);

    /**
     * 更新
     *
     * @param book
     */
    void edit(Book book);

    /**
     * 批量更新
     *
     * @param books
     */
    void batchEdit(@Param("books") List<Book> books);

    /**
     * 删除/批量删除
     *
     * @param ids
     */
    void delete(List<String> ids);
}

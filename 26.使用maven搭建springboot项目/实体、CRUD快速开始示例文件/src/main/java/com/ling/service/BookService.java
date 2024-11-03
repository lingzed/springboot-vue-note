package com.ling.service;


import com.ling.entity.PageBean;
import com.ling.entity.book.Book;
import com.ling.entity.book.BookQuery;

import java.util.List;

public interface BookService {

    /**
     * 条件分页查询
     * @param bookQuery
     * @return
     */
    PageBean<Book> find(BookQuery bookQuery);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Book findById(Integer id);

    /**
     * 新增
     * @param book
     */
    void add(Book book);

    /**
     * 批量新增
     * @param books
     */
    void batchAdd(List<Book> books);

    /**
     * 修改
     * @param book
     */
    void edit(Book book);

    /**
     * 删除/批量删除
     * @param ids
     */
    void delete(List<Integer> ids);
}

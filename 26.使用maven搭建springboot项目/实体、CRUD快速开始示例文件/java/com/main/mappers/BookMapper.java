package com.main.mappers;

import com.main.entity.po.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 查询
     *
     * @param book
     * @return
     */
    List<Book> select(Book book);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Book selectById(String id);

    /**
     * 添加
     *
     * @param book
     */
    void insert(Book book);

    /**
     * 批量添加
     *
     * @param books
     */
    void batchInsert(@Param("books") List<Book> books);

    /**
     * 更新
     *
     * @param book
     */
    void update(Book book);

    /**
     * 批量更新
     *
     * @param books
     */
    void batchUpdate(@Param("books") List<Book> books);

    /**
     * 删除/批量删除
     *
     * @param ids
     */
    void delete(List<String> ids);
}

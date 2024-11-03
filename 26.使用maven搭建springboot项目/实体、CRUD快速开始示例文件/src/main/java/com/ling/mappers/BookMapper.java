package com.ling.mappers;

import com.ling.entity.book.Book;
import com.ling.entity.book.BookQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 查询
     *
     * @param bookQuery
     * @return
     */
    List<Book> select(@Param("bookQuery") BookQuery bookQuery);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Book selectById(int id);

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
    void batchInsert(List<Book> books);

    /**
     * 更新
     *
     * @param book
     */
    void update(Book book);

    /**
     * 删除
     *
     * @param ids
     */
    void delete(List<Integer> ids);
}

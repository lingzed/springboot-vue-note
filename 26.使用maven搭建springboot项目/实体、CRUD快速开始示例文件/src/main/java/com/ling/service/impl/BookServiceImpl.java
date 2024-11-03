package com.ling.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ling.entity.BusinessException;
import com.ling.entity.PageBean;
import com.ling.entity.ResponseCodeEnum;
import com.ling.entity.book.Book;
import com.ling.entity.book.BookQuery;
import com.ling.mappers.BookMapper;
import com.ling.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public PageBean<Book> find(BookQuery bookQuery) {
        PageHelper.startPage(bookQuery.getPage(), bookQuery.getPageSize());
        List<Book> books = bookMapper.select(bookQuery);
        Page<Book> p = (Page<Book>) books;
        if (bookQuery.getPage() > p.getPages()) throw new BusinessException(ResponseCodeEnum.CODE_600);
        return PageBean.of(p.getTotal(), bookQuery.getPage(), bookQuery.getPageSize(), p.getPages(), p.getResult());
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public void add(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public void batchAdd(List<Book> books) {

    }

    @Override
    public void edit(Book book) {
        bookMapper.update(book);
    }

    @Override
    public void delete(List<Integer> ids) {
        bookMapper.delete(ids);
    }
}

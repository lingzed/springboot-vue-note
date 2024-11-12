package com.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.main.commons.CommonMsg;
import com.main.entity.po.Book;
import com.main.entity.vo.PageBean;
import com.main.exception.BusinessException;
import com.main.mappers.BookMapper;
import com.main.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public PageBean<Book> find(Book book) {
        try {
            PageHelper.startPage(book.getPage(), book.getPageSize());
            List<Book> books = bookMapper.select(book);
            Page<Book> p = (Page<Book>) books;
            return PageBean.of(p.getTotal(), book.getPage(), p.getPageSize(), p.getPages(), p.getResult());
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
        }
    }

    @Override
    public Book findById(String id) {
        try {
            return bookMapper.selectById(id);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
        }
    }

    @Override
    public void add(Book book) {
        try {
            System.out.println(book);
            Date date = new Date();
            book.setCreateTime(date);
            book.setUpdateTime(date);
            bookMapper.insert(book);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.ADD_FAIL, e);
        }
    }

    @Override
    public void batchAdd(List<Book> books) {
        try {
            Date date = new Date();
            List<Book> newBooks = books.stream().map(b -> {
                b.setCreateTime(date);
                b.setUpdateTime(date);
                return b;
            }).collect(Collectors.toList());
            bookMapper.batchInsert(newBooks);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.ADD_FAIL, e);
        }
    }

    @Override
    public void edit(Book book) {
        try {
            Date date = new Date();
            book.setUpdateTime(date);
            bookMapper.update(book);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.EDIT_FAIL, e);
        }
    }

    @Override
    public void batchEdit(List<Book> books) {
        try {
            Date date = new Date();
            List<Book> newBooks = books.stream().map(b -> {
                b.setCreateTime(date);
                b.setUpdateTime(date);
                return b;
            }).collect(Collectors.toList());
            bookMapper.batchUpdate(newBooks);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.EDIT_FAIL, e);
        }
    }

    @Override
    public void delete(List<String> ids) {
        try {
            bookMapper.delete(ids);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.DELETE_FAIL, e);
        }
    }
}

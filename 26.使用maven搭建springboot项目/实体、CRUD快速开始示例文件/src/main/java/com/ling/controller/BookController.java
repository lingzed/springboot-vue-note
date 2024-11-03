package com.ling.controller;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.ling.entity.PageBean;
import com.ling.entity.Result;
import com.ling.entity.book.Book;
import com.ling.entity.book.BookQuery;
import com.ling.service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping
    public Result<PageBean<Book>> getBookInfo(@RequestBody BookQuery bookQuery) {
        System.out.println(bookQuery);
        PageBean<Book> pageBean = bookService.find(bookQuery);
        return Result.success(pageBean);
    }
}

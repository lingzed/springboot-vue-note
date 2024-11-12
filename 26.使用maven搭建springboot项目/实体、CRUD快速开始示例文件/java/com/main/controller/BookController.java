package com.main.controller;

import com.main.entity.po.Book;
import com.main.entity.vo.PageBean;
import com.main.entity.vo.Result;
import com.main.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private Logger log = LoggerFactory.getLogger(BookController.class);

    @Resource
    private BookService bookService;

    @GetMapping
    public Result<PageBean<Book>> findBooks(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                            String name,
                                            String author,
                                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Book book = new Book();
        book.setPage(page);
        book.setPageSize(pageSize);
        book.setName(name);
        book.setAuthor(author);
        book.setStartDate(startDate);
        book.setEndDate(endDate);
        log.info("请求参数: {}", book);
        PageBean<Book> bookPageBean = bookService.find(book);
        return Result.success(bookPageBean);
    }

    @GetMapping("/{id}")
    public Result<Book> findBook(@PathVariable String id) {
        log.info("请求参数: {}", id);
        Book book = bookService.findById(id);
        return Result.success(book);
    }

    @PostMapping
    public Result addBook(@RequestBody Book book) {
        log.info("请求参数: {}", book);
        bookService.add(book);
        return Result.success();
    }

    @PostMapping("/batch")
    public Result addBooks(@RequestBody Book books) {
        log.info("请求参数: {}", books);
        bookService.batchAdd(books.getList());
        return Result.success();
    }

    @PutMapping
    public Result editBook(@RequestBody Book book) {
        log.info("请求参数: {}", book);
        bookService.edit(book);
        return Result.success();
    }

    @PutMapping("/batch")
    public Result editsBooks(@RequestBody Book books) {
        log.info("请求参数: {}", books);
        bookService.batchEdit(books.getList());
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result editsBooks(@PathVariable List<String> ids) {
        log.info("请求参数: {}", ids);
        bookService.delete(ids);
        return Result.success();
    }
}

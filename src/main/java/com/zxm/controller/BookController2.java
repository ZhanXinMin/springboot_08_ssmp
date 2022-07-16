package com.zxm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxm.domain.Book;
import com.zxm.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;
    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }
    @PutMapping
    public boolean updata(@RequestBody Book book){
        return bookService.updateById(book);
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id){
        return bookService.removeById(id);
    }
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage,pageSize);
    }
}

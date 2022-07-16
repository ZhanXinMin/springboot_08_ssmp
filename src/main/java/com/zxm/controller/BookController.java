package com.zxm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxm.controller.utils.R;
import com.zxm.domain.Book;
import com.zxm.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }
    @PostMapping
    public R save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return  new R(flag,flag?"添加成功^_^":"添加失败-_-！");
    }
    @PutMapping
    public R updata(@RequestBody Book book){

        return new R(bookService.updateById(book));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){

        IPage<Book> page = bookService.getPage(currentPage,pageSize,book);
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }
}

package com.zxm.service;

import com.zxm.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTests {
    @Autowired
    private IBookService bookService;
    @Test
    void testGetById(){
        bookService.getById(1);
    }
    @Test
    void testGetAll(){
        bookService.getMap(null);
    }
    @Test
    void testUpdata(){
        Book book = new Book();
        book.setId(1);
        book.setType("都市");
        book.setName("都市乱斗");
        book.setDescription("热血激动人心");
        bookService.updateById(book);
    }
    @Test
    void testinsert(){
        Book book = new Book();
        book.setType("热血");
        book.setName("都市乱斗");
        book.setDescription("热血激动人心");
        bookService.save(book);
    }

}

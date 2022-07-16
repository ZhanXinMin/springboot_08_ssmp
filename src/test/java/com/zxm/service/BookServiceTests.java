package com.zxm.service;

import com.zxm.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTests {
    @Autowired
    private BookService bookService;
    @Test
    void testGetById(){
        bookService.getById(1);
    }
    @Test
    void testGetAll(){
        bookService.getAll();
    }
    @Test
    void testUpdata(){
        Book book = new Book();
        book.setId(1);
        book.setType("热血");
        book.setName("都市乱斗");
        book.setDescription("热血激动人心");
        bookService.updata(book);
    }


}

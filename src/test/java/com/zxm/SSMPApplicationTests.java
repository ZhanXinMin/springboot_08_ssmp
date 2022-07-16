package com.zxm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxm.dao.BookDao;
import com.zxm.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SSMPApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void testgetById() {
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void testinsert() {
        Book book = new Book();
        book.setName("zxm");
        book.setType("科幻");
        book.setDescription("wodee");
        bookDao.insert(book);
    }
    @Test
    void testGetByPage(){
        IPage page = new Page(1,2);
        bookDao.selectPage(page,null);
        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("每页显示数"+page.getSize());
        System.out.println("一共多少页"+page.getPages());
        System.out.println("一共多少条数据"+page.getTotal());
        System.out.println("数据"+page.getRecords());
    }


}

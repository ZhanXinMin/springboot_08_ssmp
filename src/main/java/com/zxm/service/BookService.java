package com.zxm.service;

import com.zxm.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean updata(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
}

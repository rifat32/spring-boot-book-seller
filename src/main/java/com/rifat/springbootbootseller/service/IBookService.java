package com.rifat.springbootbootseller.service;

import com.rifat.springbootbootseller.model.Book;

import java.util.List;

public interface IBookService {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}

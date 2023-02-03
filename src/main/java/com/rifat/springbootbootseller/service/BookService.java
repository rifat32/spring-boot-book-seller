package com.rifat.springbootbootseller.service;

import com.rifat.springbootbootseller.model.Book;
import com.rifat.springbootbootseller.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService implements IBookService{

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book){
        book.setCreatedAt(LocalDateTime.now());
      return  bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

@Override
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
}

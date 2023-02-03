package com.rifat.springbootbootseller.repository;

import com.rifat.springbootbootseller.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}

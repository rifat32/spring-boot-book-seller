package com.rifat.springbootbootseller.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "totle", nullable = false,length = 100)
    private Long title;

    @Column(name = "description", nullable = false,length = 1000)
    private Long description;
    @Column(name = "author", nullable = false,length = 100)
    private Long author;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;
}

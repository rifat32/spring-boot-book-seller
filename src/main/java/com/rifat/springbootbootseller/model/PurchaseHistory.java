package com.rifat.springbootbootseller.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "purchase_hisories")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "book_id",nullable = false)
    private Long bookId;


    @Column(name = "price", nullable = false)
    private Double price;


    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

}

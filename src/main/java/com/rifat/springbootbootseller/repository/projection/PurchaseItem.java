package com.rifat.springbootbootseller.repository.projection;

import java.time.LocalDateTime;

public interface PurchaseItem {
    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}

package com.rifat.springbootbootseller.service;

import com.rifat.springbootbootseller.model.PurchaseHistory;

public interface IPurchaseService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);
}

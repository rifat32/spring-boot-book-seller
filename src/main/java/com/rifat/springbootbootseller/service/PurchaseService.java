package com.rifat.springbootbootseller.service;


import com.rifat.springbootbootseller.model.PurchaseHistory;
import com.rifat.springbootbootseller.repository.PurchaseRepository;
import com.rifat.springbootbootseller.repository.projection.PurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseService implements IPurchaseService {


private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setCreatedAt(LocalDateTime.now());
      return  purchaseRepository.save(purchaseHistory);
    }
    public List<PurchaseItem> findPurchasedItemsOfUser(Long userId) {
        return purchaseRepository.findAllPurchasesOfUser(userId);
    }
}

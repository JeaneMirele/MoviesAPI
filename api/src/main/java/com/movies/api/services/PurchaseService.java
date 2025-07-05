package com.movies.api.services;

import com.movies.api.domain.Purchase;
import com.movies.api.repositorys.PurchaseRepository;
import com.movies.api.services.generic.AbstractService;

public class PurchaseService extends AbstractService<Purchase, Long, PurchaseRepository> {
    public PurchaseService(PurchaseRepository repository){
        super(repository);
    }
}

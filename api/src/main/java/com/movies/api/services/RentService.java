package com.movies.api.services;

import com.movies.api.domain.Rent;
import com.movies.api.repositorys.RentRepository;
import com.movies.api.services.generic.AbstractService;

public class RentService extends AbstractService<Rent, Long, RentRepository> {
    public RentService(RentRepository repository){
        super(repository);
    }
}

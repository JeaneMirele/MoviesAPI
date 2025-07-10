package com.movies.api.services;

import com.movies.api.domain.Client;
import com.movies.api.repositorys.ClientRepository;
import com.movies.api.services.generic.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractService<Client, Long, ClientRepository> {
    public ClientService(ClientRepository repository){
        super(repository);
    }
}

package com.movies.api.services;

import com.movies.api.domain.Client;
import com.movies.api.services.generic.AbstractService;

public class ClientService extends AbstractService<Client, Long, ClientRepository> {
    public ClientService(ClientRepository repository){
        super(repository);
    }
}

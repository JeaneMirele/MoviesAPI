package com.movies.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterfaceCrud<T, ID> {

    public T create(T entity);
    public Page<T> listAll(Pageable pageable);
    public T listById(ID id);
    public T update(T entity);
    public void deleteById(ID id);
}

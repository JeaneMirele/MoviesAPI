package com.movies.api.services.generic;

import com.movies.api.services.InterfaceCrud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public abstract class AbstractService<T, ID, Repo extends JpaRepository<T, ID>> implements InterfaceCrud<T, ID> {
    protected final Repo repository;

    public AbstractService(Repo repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public Page<T> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T listById(ID id) {
        Optional<T> op = repository.findById(id);
        return op.orElseThrow(() -> new RuntimeException("Not found"));
        //Vou deixar essa exception, enquanto não fazemos o handler
    }

    @Override
    public T update(T entity){
        return repository.save(entity);
    }


    @Override
    public void deleteById(ID id) {
        T Entity = this.listById(id);
        repository.delete(Entity);
    }
}

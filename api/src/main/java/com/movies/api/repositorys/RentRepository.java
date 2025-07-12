package com.movies.api.repositorys;

import com.movies.api.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}

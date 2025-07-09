package com.movies.api.repositorys;

import com.movies.api.domain.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer> {

Optional<SecurityUser> findByUsername(String username);
}

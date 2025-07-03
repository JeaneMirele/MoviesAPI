package com.movies.api.repositorys;

import com.movies.api.domain.Award;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Award, Long> {
}

package com.movies.api.services;

import com.movies.api.domain.Award;
import com.movies.api.repositorys.AwardRepository;
import com.movies.api.services.generic.AbstractService;

public class AwardService extends AbstractService<Award, Long, AwardRepository> {
    public AwardService(AwardRepository repository) {
        super(repository);
    }
}

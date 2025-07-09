package com.movies.api.services;

import com.movies.api.repositorys.SecurityUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {
    private final SecurityUserRepository repository;

    public SecurityUserService(SecurityUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found user " + username));
    }
}

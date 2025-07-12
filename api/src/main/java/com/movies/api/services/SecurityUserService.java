package com.movies.api.services;

import com.movies.api.domain.SecurityUser;
import com.movies.api.repositorys.SecurityUserRepository;
import com.movies.api.services.generic.AbstractService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService extends AbstractService<SecurityUser, Long, SecurityUserRepository> implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    public SecurityUserService(SecurityUserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found user " + username));
    }

    public SecurityUser findByUsername(String username){
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found user " + username));
    }

    @Override
    public SecurityUser create(SecurityUser securityUser) {
        securityUser.setPassword(passwordEncoder.encode(securityUser.getPassword()));
        return repository.save(securityUser);
    }
}

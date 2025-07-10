package com.movies.api.controller;

import com.movies.api.dto.ClientSaveRequestDto;
import com.movies.api.mapper.SecurityUserMapper;
import com.movies.api.services.ClientService;
import com.movies.api.services.SecurityUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final SecurityUserService securityUserService;
    private final ClientService clientService;
    private final SecurityUserMapper securityUserMapper;

    public ClientController(SecurityUserService securityUserService, ClientService clientService, SecurityUserMapper securityUserMapper) {
        this.securityUserService = securityUserService;
        this.clientService = clientService;
        this.securityUserMapper = securityUserMapper;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ClientSaveRequestDto dto) {
        this.securityUserService.create(securityUserMapper.toEntity(dto));
        return ResponseEntity.noContent().build();
    }
}

package com.jeison.beautycentermanagementsytem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeison.beautycentermanagementsytem.api.dto.response.ClientResponse;
import com.jeison.beautycentermanagementsytem.infrastructure.abstract_services.IClientService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api")
public class ClientController {

    @Autowired
    private final IClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findByIdWithDetails(id));
    }
    

}

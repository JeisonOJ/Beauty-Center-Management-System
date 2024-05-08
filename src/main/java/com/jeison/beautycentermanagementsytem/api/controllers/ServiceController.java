package com.jeison.beautycentermanagementsytem.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeison.beautycentermanagementsytem.api.dto.request.ServiceRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.ServiceResponse;
import com.jeison.beautycentermanagementsytem.infrastructure.abstract_services.IServiceService;
import com.jeison.beautycentermanagementsytem.utils.enums.SortType;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@AllArgsConstructor
@RequestMapping("services")
public class ServiceController {

    @Autowired
    private final IServiceService service;

    @GetMapping
    public ResponseEntity<Page<ServiceResponse>> getAll(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false) SortType sortType) {

        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }
        return ResponseEntity.ok(service.findAll(page - 1, size, sortType));
    }

    @PostMapping
    public ResponseEntity<ServiceResponse> create(@Validated @RequestBody ServiceRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<ServiceResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByIdWithDetails(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable Long id, @Validated @RequestBody ServiceRequest request) {
        return ResponseEntity.ok(service.update(request, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    

    

}

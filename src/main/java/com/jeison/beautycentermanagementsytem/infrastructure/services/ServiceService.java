package com.jeison.beautycentermanagementsytem.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeison.beautycentermanagementsytem.api.dto.request.ServiceRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.ServiceResponse;
import com.jeison.beautycentermanagementsytem.domain.repositories.ServiceRepository;
import com.jeison.beautycentermanagementsytem.infrastructure.abstract_services.IServiceService;
import com.jeison.beautycentermanagementsytem.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ServiceService implements IServiceService{

    @Autowired
    private final ServiceRepository serviceRepository;

    @Override
    public Page<ServiceResponse> findAll(int page, int size, SortType sortYype) {
        if (page<0) page=0;
        PageRequest pagination = null;

        switch (sortYype) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        Pageable pageable = pagination;
        return serviceRepository.findAll(pageable);
    }

    @Override
    public ServiceResponse findByIdWithDetails(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdWithDetails'");
    }

    @Override
    public ServiceResponse create(ServiceRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ServiceResponse update(ServiceRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ServiceResponse> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}

package com.jeison.beautycentermanagementsytem.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeison.beautycentermanagementsytem.api.dto.request.ServiceRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.ServiceResponse;
import com.jeison.beautycentermanagementsytem.domain.entities.ServiceEntity;
import com.jeison.beautycentermanagementsytem.domain.repositories.ServiceRepository;
import com.jeison.beautycentermanagementsytem.infrastructure.abstract_services.IServiceService;
import com.jeison.beautycentermanagementsytem.utils.enums.SortType;
import com.jeison.beautycentermanagementsytem.utils.exception.BadRequestException;
import com.jeison.beautycentermanagementsytem.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ServiceService implements IServiceService {

    @Autowired
    private final ServiceRepository serviceRepository;

    @Override
    public Page<ServiceResponse> findAll(int page, int size, SortType sortYype) {
        if (page < 0)
            page = 0;
        PageRequest pagination = null;

        switch (sortYype) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
            default -> throw new IllegalArgumentException("No valid sort: " + sortYype);
        }
        Pageable pageable = pagination;
        return serviceRepository.findAll(pageable).map(this::entityToResp);
    }

    @Override
    public ServiceResponse findByIdWithDetails(Long id) {
        ServiceEntity serviceEntity = findById(id);
        return entityToResp(serviceEntity);

    }

    @Override
    public ServiceResponse create(ServiceRequest request) {
        return entityToResp(serviceRepository.save(requestToEntity(request, new ServiceEntity())));
    }

    @Override
    public ServiceResponse update(ServiceRequest request, Long id) {
        ServiceEntity serviceEntity = findById(id);
        return entityToResp(serviceRepository.save(requestToEntity(request, serviceEntity)));
        
    }

    @Override
    public void delete(Long id) {
        ServiceEntity serviceEntity = findById(id);
        serviceRepository.delete(serviceEntity);
    }

    @Override
    public List<ServiceResponse> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    private ServiceResponse entityToResp(ServiceEntity service) {
        ServiceResponse serviceResponse = new ServiceResponse();
        BeanUtils.copyProperties(service, serviceResponse);
        return serviceResponse;
    }

    private ServiceEntity requestToEntity(ServiceRequest request, ServiceEntity serviceEntity) {
        serviceEntity.setAppointment(new ArrayList<>());
        BeanUtils.copyProperties(request, serviceEntity);
        return serviceEntity;
    }

    private ServiceEntity findById(Long id){
        return serviceRepository.findById(id).orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("Service")));
    }

}

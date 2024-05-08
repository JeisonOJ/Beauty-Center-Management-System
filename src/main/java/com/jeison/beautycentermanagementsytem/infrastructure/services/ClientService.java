package com.jeison.beautycentermanagementsytem.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jeison.beautycentermanagementsytem.api.dto.request.ClientRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.ClientResponse;
import com.jeison.beautycentermanagementsytem.api.dto.response.EmployeeResponse;
import com.jeison.beautycentermanagementsytem.api.dto.response.ServiceResponse;
import com.jeison.beautycentermanagementsytem.api.dto.response.SimpleAppoinmentResp;
import com.jeison.beautycentermanagementsytem.domain.entities.Appointment;
import com.jeison.beautycentermanagementsytem.domain.entities.ClientEntity;
import com.jeison.beautycentermanagementsytem.domain.repositories.ClientRepository;
import com.jeison.beautycentermanagementsytem.infrastructure.abstract_services.IClientService;
import com.jeison.beautycentermanagementsytem.infrastructure.helpers.ObjectConverter;
import com.jeison.beautycentermanagementsytem.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    @Autowired
    private final ClientRepository clientRepository;

    @Override
    public Page<ClientResponse> findAll(int page, int size, SortType sortYype) {
        if (page < 0)
            page = 0;
        PageRequest pageRequest = null;

        switch (sortYype) {
            case NONE -> pageRequest = PageRequest.of(page, size);
            case ASC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
            default -> throw new IllegalArgumentException("No valid sort: " + sortYype);
        }

        Pageable pageable = pageRequest;
        return clientRepository.findAll(pageable).map(this::entityToResponse);

    }

    @Override
    public ClientResponse findByIdWithDetails(Long id) {
        ClientEntity client = clientRepository.findById(id).orElseThrow();
        ClientResponse clientResponse = ObjectConverter.ClientToResponse(client);
        // clientResponse.setAppointment(appointmentRepository.findByClientId(client.getId()).stream().map(appointment
        // ->
        // ObjectConverter.appointmentToResponse(appointment)).collect(Collectors.toList()));
        return clientResponse;
    }

    @Override
    public ClientResponse create(ClientRequest request) {
        return ObjectConverter
                .ClientToResponse(clientRepository.save(ObjectConverter.requestToClient(request, new ClientEntity())));

    }

    @Override
    public ClientResponse update(ClientRequest request, Long id) {
        ClientEntity client = getById(id);
        return ObjectConverter
                .ClientToResponse(clientRepository.save(ObjectConverter.requestToClient(request, client)));

    }

    @Override
    public void delete(Long id) {
        ClientEntity client = getById(id);
        clientRepository.delete(client);
    }

    private ClientEntity getById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    private ClientResponse entityToResponse(ClientEntity entity) {
        ClientResponse clientResponse = new ClientResponse();
        List<SimpleAppoinmentResp> appoinmentResps = entity.getAppointment().stream().map(this::AppointmentToSimpleResponse).toList();
        clientResponse.setAppointment(appoinmentResps);
        BeanUtils.copyProperties(entity, clientResponse);
        return clientResponse;
    }

    private SimpleAppoinmentResp AppointmentToSimpleResponse(Appointment appointment) {
        SimpleAppoinmentResp simpleAppoinmentResp = new SimpleAppoinmentResp();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        ServiceResponse serviceResponse = new ServiceResponse();
        BeanUtils.copyProperties(appointment.getEmployee(), employeeResponse);
        BeanUtils.copyProperties(appointment.getService(), serviceResponse);
        simpleAppoinmentResp.setEmployeeResponse(employeeResponse);
        simpleAppoinmentResp.setServiceResponse(serviceResponse);
        BeanUtils.copyProperties(appointment, simpleAppoinmentResp);
        return simpleAppoinmentResp;
    }

}

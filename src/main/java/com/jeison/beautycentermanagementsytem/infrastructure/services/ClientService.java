package com.jeison.beautycentermanagementsytem.infrastructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeison.beautycentermanagementsytem.api.dto.request.ClientRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.ClientResponse;
import com.jeison.beautycentermanagementsytem.domain.entities.Client;
import com.jeison.beautycentermanagementsytem.domain.repositories.AppointmentRepository;
import com.jeison.beautycentermanagementsytem.domain.repositories.ClientRepository;
import com.jeison.beautycentermanagementsytem.infrastructure.abstract_services.IClientService;
import com.jeison.beautycentermanagementsytem.infrastructure.helpers.ObjectConverter;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Override
    public List<ClientResponse> findAll() {
        return clientRepository.findAll().stream().map(client -> ObjectConverter.ClientToResponse(client)).collect(Collectors.toList());
    }

    @Override
    public ClientResponse findByIdWithDetails(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        ClientResponse clientResponse = ObjectConverter.ClientToResponse(client);
        clientResponse.setAppointment(appointmentRepository.findByClientId(client.getId()).stream().map(appointment -> ObjectConverter.appointmentToResponse(appointment)).collect(Collectors.toList()));
        return clientResponse;
    }

    @Override
    public ClientResponse create(ClientRequest request) {
        return ObjectConverter.ClientToResponse(clientRepository.save(ObjectConverter.requestToClient(request, new Client())));

    }

    @Override
    public ClientResponse update(ClientRequest request, Long id) {
        Client client = getById(id);
        return ObjectConverter.ClientToResponse(clientRepository.save(ObjectConverter.requestToClient(request, client)));

    }

    @Override
    public void delete(Long id) {
        Client client = getById(id);
        clientRepository.delete(client);
    }

    private Client getById(Long id){
        return clientRepository.findById(id).orElseThrow();
    }

    



}

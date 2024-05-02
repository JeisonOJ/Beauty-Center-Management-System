package com.jeison.beautycentermanagementsytem.infrastructure.helpers;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.jeison.beautycentermanagementsytem.api.dto.request.ClientRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.AppointmentResponse;
import com.jeison.beautycentermanagementsytem.api.dto.response.ClientResponse;
import com.jeison.beautycentermanagementsytem.domain.entities.Appointment;
import com.jeison.beautycentermanagementsytem.domain.entities.Client;

public class ObjectConverter {

    public static ClientResponse ClientToResponse(Client client){
        ClientResponse clientResponse = new ClientResponse();
        BeanUtils.copyProperties(client, clientResponse);
        return clientResponse;
    }

    public static Client requestToClient(ClientRequest request, Client client){
        client.setAppointment(new ArrayList<>());
        BeanUtils.copyProperties(request, client);
        return client;
    }

    public static AppointmentResponse appointmentToResponse(Appointment appointment){
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        BeanUtils.copyProperties(appointment, appointmentResponse);
        return appointmentResponse;
    }

}

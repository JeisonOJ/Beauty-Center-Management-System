package com.jeison.beautycentermanagementsytem.infrastructure.abstract_services;

import java.util.List;

import com.jeison.beautycentermanagementsytem.api.dto.request.AppointmentRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.AppointmentResponse;
import com.jeison.beautycentermanagementsytem.domain.entities.Appointment;

public interface IAppointmentService extends CrudService<AppointmentRequest,AppointmentResponse,Long>{

    public List<Appointment> findByClientId(Long id);
}

package com.jeison.beautycentermanagementsytem.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jeison.beautycentermanagementsytem.api.dto.request.AppointmentRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.AppointmentResponse;
import com.jeison.beautycentermanagementsytem.domain.entities.Appointment;
import com.jeison.beautycentermanagementsytem.domain.repositories.AppointmentRepository;
import com.jeison.beautycentermanagementsytem.infrastructure.abstract_services.IAppointmentService;
import com.jeison.beautycentermanagementsytem.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService{

    @Autowired
    private final AppointmentRepository appointmentRepository;

    // @Override
    // public List<AppointmentResponse> findAll() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    // }

    @Override
    public AppointmentResponse findByIdWithDetails(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdWithDetails'");
    }

    @Override
    public AppointmentResponse create(AppointmentRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public AppointmentResponse update(AppointmentRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        Appointment appointment = getById(id);
        appointmentRepository.delete(appointment);
    }

    private Appointment getById(Long id){
        return appointmentRepository.findById(id).orElseThrow();
    }

    // @Override
    // public Optional<Appointment> findByClientId(Long id) {
    //     return appointmentRepository.findByClientById(id);
    // }

    @Override
    public Page<AppointmentResponse> findAll(int page, int size, SortType sortYype) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Appointment> findByClientId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByClientId'");
    }

}

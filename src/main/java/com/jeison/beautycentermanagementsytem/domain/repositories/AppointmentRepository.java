package com.jeison.beautycentermanagementsytem.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeison.beautycentermanagementsytem.domain.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    public List<Appointment> findByClientId(Long id);

}

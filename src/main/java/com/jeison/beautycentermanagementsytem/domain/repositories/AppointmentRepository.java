package com.jeison.beautycentermanagementsytem.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeison.beautycentermanagementsytem.domain.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Query("select p from appointment p join fetch p.client c where c.id = :idClient")
    public Optional<Appointment> findByClientById(Long idClient);

}

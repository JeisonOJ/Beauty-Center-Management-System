package com.jeison.beautycentermanagementsytem.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeison.beautycentermanagementsytem.domain.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {

}
package com.jeison.beautycentermanagementsytem.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeison.beautycentermanagementsytem.domain.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

}

package com.jeison.beautycentermanagementsytem.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private Integer durarion;
    @Lob
    private String comments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clients_id", referencedColumnName = "id")
    private ClientEntity client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employees_id", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "services_id", referencedColumnName = "id")
    private ServiceEntity service;
}

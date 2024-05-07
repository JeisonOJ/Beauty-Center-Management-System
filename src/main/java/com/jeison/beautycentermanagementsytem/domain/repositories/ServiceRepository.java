package com.jeison.beautycentermanagementsytem.domain.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeison.beautycentermanagementsytem.domain.entities.ServiceEntity;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Long> {

    @Query("select s from serviceEntity s where s.price between :min and :max")
    //si no hacemos el query igual jpa tiene esta consulta
    public List<ServiceEntity> selectBetWeenPrice(BigDecimal min, BigDecimal max);

    public List<ServiceEntity> findByNameContaining(String name);
}

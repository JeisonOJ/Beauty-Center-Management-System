package com.jeison.beautycentermanagementsytem.infrastructure.abstract_services;

import java.util.List;

import com.jeison.beautycentermanagementsytem.api.dto.request.ServiceRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.ServiceResponse;

public interface IServiceService extends CrudService<ServiceRequest,ServiceResponse,Long>{

    public List<ServiceResponse> search(String name);
    public final String FIELD_BY_SORT = "price";

}

package com.jeison.beautycentermanagementsytem.infrastructure.abstract_services;

import com.jeison.beautycentermanagementsytem.api.dto.request.ServiceRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.ServiceResponse;

public interface IServiceService extends CrudService<ServiceRequest,ServiceResponse,Long>{

}

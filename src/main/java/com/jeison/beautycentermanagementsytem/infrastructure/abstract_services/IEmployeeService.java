package com.jeison.beautycentermanagementsytem.infrastructure.abstract_services;

import com.jeison.beautycentermanagementsytem.api.dto.request.EmployeeRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.EmployeeResponse;

public interface IEmployeeService extends CrudService<EmployeeRequest,EmployeeResponse,Long>{

}

package com.jeison.beautycentermanagementsytem.infrastructure.abstract_services;

import com.jeison.beautycentermanagementsytem.api.dto.request.ClientRequest;
import com.jeison.beautycentermanagementsytem.api.dto.response.ClientResponse;

public interface IClientService extends CrudService<ClientRequest,ClientResponse,Long>{

}

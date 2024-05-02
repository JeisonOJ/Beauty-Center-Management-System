package com.jeison.beautycentermanagementsytem.infrastructure.abstract_services;

import java.util.List;

public interface CrudService<RQ, RS, ID> {

    public List<RS> findAll();

    public RS findByIdWithDetails(ID id);

    public RS create(RQ request);

    public RS update(RQ request, ID id);

    public void delete(ID id);

}

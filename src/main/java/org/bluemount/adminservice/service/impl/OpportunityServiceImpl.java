package org.bluemount.adminservice.service.impl;

import lombok.NonNull;
import org.bluemount.adminservice.model.Opportunity;
import org.bluemount.adminservice.repositories.OpportunityRepository;
import org.bluemount.adminservice.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    private OpportunityRepository repository;


    @Override
    public Opportunity createOpportunity(@NonNull Opportunity opportunity) {
        return repository.save(opportunity);
    }

    @Override
    public Opportunity updateOpportunity(@NonNull String id, @NonNull Opportunity opportunity) {
        Opportunity existingOpportunity = getOpportunity(id);
        if (Objects.isNull(existingOpportunity)) {
            return null;
        } else {
            existingOpportunity.patch(opportunity);
        }
        return repository.save(existingOpportunity);
    }

    @Override
    public Opportunity getOpportunity(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Opportunity> getAllOpportunities() {
        return repository.findAll();
    }

    public Opportunity getOpportunityByCode(String opp_code){
        return repository.findByCode(opp_code);
    }
}

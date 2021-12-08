package org.bluemount.adminservice.service;

import lombok.NonNull;
import org.bluemount.adminservice.model.Opportunity;

public interface OpportunityService {

    Opportunity createOpportunity(@NonNull Opportunity opportunity);

    Opportunity updateOpportunity(@NonNull String id, @NonNull Opportunity opportunity);

    Opportunity getOpportunity(String id);

    Opportunity getOpportunityByCode(String opp_code);

    Iterable<Opportunity> getAllOpportunities();


}

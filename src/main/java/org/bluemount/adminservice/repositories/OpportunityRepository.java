package org.bluemount.adminservice.repositories;

import org.bluemount.adminservice.model.Opportunity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends CrudRepository<Opportunity,String> {

    Opportunity findByCode(@Param("code") String code);

}

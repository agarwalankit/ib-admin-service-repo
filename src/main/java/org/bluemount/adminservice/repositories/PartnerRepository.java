package org.bluemount.adminservice.repositories;

import org.bluemount.adminservice.model.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends CrudRepository<Partner,String> {
}

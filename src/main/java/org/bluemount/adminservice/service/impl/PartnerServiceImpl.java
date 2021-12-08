package org.bluemount.adminservice.service.impl;

import lombok.NonNull;
import org.bluemount.adminservice.model.Partner;
import org.bluemount.adminservice.repositories.PartnerRepository;
import org.bluemount.adminservice.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository repository;

    @Override
    public Partner createPartner(@NonNull Partner partner) {
        return repository.save(partner);
    }

    @Override
    public Partner updatePartner(@NonNull String partner_id, @NonNull Partner partner) {
        Partner existingPartner = getPartner(partner_id);
        if (Objects.isNull(existingPartner)) {
            return null;
        } else {
            existingPartner.patch(partner);
        }
        return repository.save(existingPartner);
    }

    @Override
    public Partner getPartner(@NonNull String partner_id) {
        return repository.findById(partner_id).orElse(null);
    }

    @Override
    public Iterable<Partner> getAllPartners() {
        return repository.findAll();
    }
}

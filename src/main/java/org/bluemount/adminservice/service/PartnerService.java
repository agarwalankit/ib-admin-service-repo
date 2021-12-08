package org.bluemount.adminservice.service;

import lombok.NonNull;
import org.bluemount.adminservice.model.Partner;

public interface PartnerService {

    Partner createPartner(@NonNull Partner partner);

    Partner updatePartner(@NonNull String partner_id, @NonNull Partner partner);

    Partner getPartner(@NonNull String partner_id);

    Iterable<Partner> getAllPartners();



}

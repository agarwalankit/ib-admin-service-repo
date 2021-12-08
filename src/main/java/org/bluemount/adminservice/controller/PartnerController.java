package org.bluemount.adminservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.bluemount.adminservice.model.Partner;
import org.bluemount.adminservice.service.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    Logger logger = LoggerFactory.getLogger(OpportunityController.class);

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private PartnerService partnerService;

    @GetMapping(value = "/all", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Get all partners")
    public ResponseEntity<Iterable<Partner>> getAllPartners() {
        return ResponseEntity.ok(partnerService.getAllPartners());

    }

    @GetMapping(value = "/{partnerId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Get partner by id")
    public ResponseEntity<Partner> getPartner(@PathVariable("partnerId") String partnerId) {
        return ResponseEntity.ok(partnerService.getPartner(partnerId));

    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Create a new partner")
    public ResponseEntity<Partner> createOpportunity(@RequestBody String oppJson) {
        try {
            Partner partner = mapper.readValue(oppJson, Partner.class);
            logger.info("Starting the request to create a new partner" + partner);
            if (validateNewPartner(partner)) {
                return ResponseEntity.ok(partnerService.createPartner(partner));
            } else {
                throw new RuntimeException("Bad Request");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Bad Request");
        }
    }

    private boolean validateNewPartner(Partner partner) {
        return true;
    }
}

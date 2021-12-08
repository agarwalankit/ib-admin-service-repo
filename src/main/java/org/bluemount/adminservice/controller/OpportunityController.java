package org.bluemount.adminservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.bluemount.adminservice.model.Opportunity;
import org.bluemount.adminservice.service.OpportunityService;
import org.bluemount.adminservice.service.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/opportunity")
public class OpportunityController {

    Logger logger = LoggerFactory.getLogger(OpportunityController.class);

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private OpportunityService opportunityService;

    @Autowired
    private PartnerService partnerService;

    @GetMapping(value = "/all", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Get all opportunities")
    public ResponseEntity<Iterable<Opportunity>> getAllOpportunities() {
        return ResponseEntity.ok(opportunityService.getAllOpportunities());

    }

    @GetMapping(value = "/{oppId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Get opportunity by id")
    public ResponseEntity<Opportunity> getOpportunity(@PathVariable("oppId") String oppId) {
        return ResponseEntity.ok(opportunityService.getOpportunity(oppId));

    }


    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Create a new opportunity")
    public ResponseEntity<Opportunity> createOpportunity(@RequestBody String oppJson) {
        try {
            Opportunity opportunity = mapper.readValue(oppJson, Opportunity.class);
            logger.info("Starting the request to create a new opportunity" + opportunity);
            if (validateNewOpportunity(opportunity)) {
                return ResponseEntity.ok(opportunityService.createOpportunity(opportunity));
            } else {
                throw new RuntimeException("Bad Request");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Bad Request");
        }
    }

    private boolean validateNewOpportunity(Opportunity opportunity) {
        if (StringUtils.isNotBlank(opportunity.getOpportunity_id())) {
            return false;
        } else if (Objects.isNull(partnerService.getPartner(opportunity.getPartner_id()))) {
            return false;
        } else
            return Objects.isNull(opportunityService.getOpportunityByCode(opportunity.getCode()));
    }
}



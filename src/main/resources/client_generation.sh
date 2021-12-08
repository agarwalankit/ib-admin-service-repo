#!/usr/bin/env bash
java -jar swagger-codegen-cli-2.4.19.jar generate \
        -i http://localhost:8080/v2/api-docs \
        --api-package in.marketready.services.leagueservice.client \
        --model-package in.marketready.services.leagueservice.model \
        --invoker-package in.marketready.services.leagueservice.invoker \
        --group-id in.marketready.services \
        --artifact-id leagueservice-api-client \
        --artifact-version 0.0.1-SNAPSHOT \
        -l java \
        --library resttemplate \
       -o spring-swagger-codegen-api-client
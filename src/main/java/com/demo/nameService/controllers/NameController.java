package com.demo.nameService.controllers;

import com.demo.nameService.requests.Name;
import com.demo.nameService.services.NameService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/name")
public class NameController {
    public static final Logger LOGGER = LoggerFactory.getLogger(NameController.class);

    private NameService nameService;

    public NameController(NameService nameService){
        this.nameService=nameService;
    }

    @PostMapping
    @Operation(
            summary = "Concatenate Name",
            description = "Concatenates first name and last name and return the value"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully concatenated names user"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<String> concatenateName(@RequestHeader(value = "X-trace-id", required = false) String traceId, @Valid @RequestBody Name name){
        LOGGER.info("RequestBody: {}",name);
        LOGGER.info("traceId: {}",traceId);
        String response = nameService.concatenate(name);

        return ResponseEntity.ok().header("X-trace-Id", traceId).body(response);
    }
}

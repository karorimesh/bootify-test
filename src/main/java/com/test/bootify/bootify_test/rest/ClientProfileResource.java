package com.test.bootify.bootify_test.rest;

import com.test.bootify.bootify_test.model.ClientProfileDTO;
import com.test.bootify.bootify_test.service.ClientProfileService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(  value = "/api/clientProfiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientProfileResource {

    private final ClientProfileService clientProfileService;

    public ClientProfileResource(final ClientProfileService clientProfileService) {
        this.clientProfileService = clientProfileService;
    }

    @GetMapping
    public ResponseEntity<List<ClientProfileDTO>> getAllClientProfiles() {
        return ResponseEntity.ok(clientProfileService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientProfileDTO> getClientProfile(
            @PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(clientProfileService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createClientProfile(
            @RequestBody @Valid final ClientProfileDTO clientProfileDTO) {
        final Long createdId = clientProfileService.create(clientProfileDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateClientProfile(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final ClientProfileDTO clientProfileDTO) {
        clientProfileService.update(id, clientProfileDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteClientProfile(@PathVariable(name = "id") final Long id) {
        clientProfileService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

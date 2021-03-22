package com.ivasi.ecar.vehicles.web;

import com.ivasi.ecar.vehicles.models.ECar;
import com.ivasi.ecar.vehicles.models.dto.ECarExportDto;
import com.ivasi.ecar.vehicles.service.ECarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/api/e-cars")
@CrossOrigin
public class ECarsController {

    private final ECarsService eCarsService;

    @Autowired
    public ECarsController(ECarsService eCarsService) {
        this.eCarsService = eCarsService;
    }

    @GetMapping
    public Collection<ECarExportDto> getAll() {
        return this.eCarsService.getAll();
    }

    @GetMapping("/{id}")
    public ECarExportDto getById(@PathVariable ("id") String id) {
        return this.eCarsService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ECar> create(@RequestBody ECar body, Authentication authentication) {
        ECar created = this.eCarsService.create(body);
        URI location = MvcUriComponentsBuilder.fromMethodName(ECarsController.class,
                "create", body, authentication)
                .pathSegment("{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }
}

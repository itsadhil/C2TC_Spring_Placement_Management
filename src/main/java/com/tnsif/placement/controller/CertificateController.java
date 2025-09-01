package com.tnsif.placement.controller;

import com.tnsif.placement.entity.Certificate;
import com.tnsif.placement.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // CREATE
    @PostMapping
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return certificateService.saveCertificate(certificate);
    }

    // READ - Get Certificate by ID
    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable Long id) {
        return certificateService.getCertificateById(id);
    }

    // READ - Get All Certificates
    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable Long id, @RequestBody Certificate certificate) {
        certificate.setId(id);  // Ensure correct ID is set
        return certificateService.saveCertificate(certificate);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }
}

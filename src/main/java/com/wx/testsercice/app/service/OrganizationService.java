package com.wx.testsercice.app.service;


import com.wx.testsercice.infra.dto.OrganizationDTO;
import org.springframework.http.ResponseEntity;

public interface OrganizationService {
    OrganizationDTO queryOrganizationById(Long organization_id);

    OrganizationDTO querylocalOrganizationById(Long id);
}

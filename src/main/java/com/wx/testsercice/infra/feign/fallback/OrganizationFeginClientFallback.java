package com.wx.testsercice.infra.feign.fallback;

import com.wx.testsercice.infra.dto.OrganizationDTO;
import com.wx.testsercice.infra.feign.OrganizationFeginClient;
import io.choerodon.core.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/*@Component*/
public class OrganizationFeginClientFallback implements OrganizationFeginClient {
    private static final String FEIGN_ERROR = "organization.error";

    @Override
    public OrganizationDTO queryOrganizationById(Long id) {
        throw new CommonException(FEIGN_ERROR);
    }
}

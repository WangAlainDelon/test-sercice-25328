package com.wx.testsercice.infra.feign;


import com.wx.testsercice.infra.dto.OrganizationDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("iam-service")
public interface OrganizationFeginClient {
    /**
     * 查询组织id为 1 的组织详情
     */
    @RequestMapping(value = "/v1/organizations/{organization_id}",method = RequestMethod.GET)
     OrganizationDTO queryOrganizationById(@PathVariable(name = "organization_id") Long organization_id);
}

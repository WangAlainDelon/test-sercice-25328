package com.wx.testsercice.infra.feign;

import com.wx.testsercice.infra.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("iam-service")
public interface UserFeignClient {

    @GetMapping(value = "/v1/organizations/{organization_id}/users/{user_id}")
    public UserDTO query(@PathVariable(name = "organization_id") Long oid, @PathVariable(name = "user_id") Long uid);

}

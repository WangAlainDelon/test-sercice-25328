package com.wx.testsercice.infra.feign.fallback;

import com.wx.testsercice.infra.dto.UserDTO;
import com.wx.testsercice.infra.feign.UserFeignClient;
import io.choerodon.core.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/*@Component*/
public class UserFeginClientFallback implements UserFeignClient {
    private static final String FEIGN_ERROR = "user.error";
    @Override
    public UserDTO query(Long oid, Long uid) {
        throw new CommonException(FEIGN_ERROR);
    }
}

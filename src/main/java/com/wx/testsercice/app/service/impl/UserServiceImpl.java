package com.wx.testsercice.app.service.impl;


import com.wx.testsercice.app.service.UserService;
import com.wx.testsercice.infra.dto.OrganizationDTO;
import com.wx.testsercice.infra.dto.UserDTO;
import com.wx.testsercice.infra.feign.UserFeignClient;
import com.wx.testsercice.infra.mapper.OrganizationMapper;
import com.wx.testsercice.infra.mapper.UserMapper;
import io.choerodon.core.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserFeignClient userFeignClient;
    private UserMapper userMapper;
    private OrganizationMapper organizationMapper;

    public UserServiceImpl(UserFeignClient userFeignClient, UserMapper userMapper, OrganizationMapper organizationMapper) {
        this.userFeignClient = userFeignClient;
        this.userMapper = userMapper;
        this.organizationMapper = organizationMapper;
    }


    @Override
    public UserDTO query(Long oid, Long uid) {
        UserDTO query = userFeignClient.query(oid, uid);
        if (query != null) {
            userMapper.insert(query);
        }
        return query;
    }

    @Override
    public UserDTO querylocalUserById(Long oid, Long uid) {

        OrganizationDTO organizationDTO = organizationMapper.selectByPrimaryKey(oid);
        if (organizationDTO == null) {
            throw new CommonException("rror.organization.not.exist");
        }
        return userMapper.selectByPrimaryKey(uid);
    }
}

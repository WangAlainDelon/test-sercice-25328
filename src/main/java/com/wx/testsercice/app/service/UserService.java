package com.wx.testsercice.app.service;


import com.wx.testsercice.infra.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserDTO query(Long oid, Long uid);
    UserDTO querylocalUserById(Long oid, Long uid);
}

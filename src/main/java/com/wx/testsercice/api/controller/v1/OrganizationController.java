package com.wx.testsercice.api.controller.v1;

import com.wx.testsercice.app.service.OrganizationService;
import com.wx.testsercice.app.service.UserService;
import com.wx.testsercice.infra.dto.OrganizationDTO;
import com.wx.testsercice.infra.dto.UserDTO;
import com.wx.testsercice.infra.feign.OrganizationFeginClient;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/organizations")
public class OrganizationController {

    private OrganizationService organizationService;
    private UserService userService;
  /*  @Autowired
    private OrganizationFeginClient organizationFeginClient;*/

    public OrganizationController(OrganizationService organizationService, UserService userService) {
        this.organizationService = organizationService;
        this.userService = userService;
    }

    /**
     * 根据组织id查询组织
     *
     * @param id 所要查询的组织id号
     * @return 组织信息
     */
    @Permission(permissionPublic = true)
    @ApiOperation(value = "全局层根据组织id查询猪⻮⻥的iam-service的组织")
    @GetMapping(value = "/{organization_id}")
    public ResponseEntity<OrganizationDTO> query(@PathVariable(name = "organization_id") Long id) {
        System.out.println(id);
        OrganizationDTO organizationDTO = organizationService.queryOrganizationById(id);
        return new ResponseEntity<>(organizationDTO, HttpStatus.OK);
    }

    /**
     * 本服务根据id查询组织
     *
     * @param id
     * @return
     */
    @Permission(permissionPublic = true)
    @ApiOperation(value = "本服务根据id查询组织")
    @GetMapping(value = "/local/{organization_id}")
    public ResponseEntity<OrganizationDTO> localquery(@PathVariable(name = "organization_id") Long id) {
        OrganizationDTO organizationDTOResponseEntity = organizationService.querylocalOrganizationById(id);
        return new ResponseEntity<>(organizationDTOResponseEntity, HttpStatus.OK);
    }

    /**
     * 查询⽤户id为1（组织id为1）的⽤户
     */
    @Permission(permissionPublic = true)
    @ApiOperation("查询iam⽤户id为1（组织id为1）的⽤户")
    @GetMapping("/{organization_id}/users/{user_id}")
    public ResponseEntity<UserDTO> getUserByOidAndUid(@PathVariable(name = "organization_id") Long organizationId,
                                                      @PathVariable(name = "user_id") Long userId) {
        UserDTO query = userService.query(organizationId, userId);
        return new ResponseEntity<>(query, HttpStatus.OK);
    }

    /**
     * 查询本地id为1（组织id为1）的⽤户
     */
    @Permission(permissionPublic = true)
    @ApiOperation("查询本地⽤户id为1（组织id为1）的⽤户")
    @GetMapping("/local/{organization_id}/users/{user_id}")
    public ResponseEntity<UserDTO> getLocalUserByOidAndUid(@PathVariable(name = "organization_id") Long organizationId,
                                                           @PathVariable(name = "user_id") Long userId) {
        UserDTO userDTO = userService.querylocalUserById(organizationId, userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}

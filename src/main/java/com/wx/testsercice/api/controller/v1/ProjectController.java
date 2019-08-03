package com.wx.testsercice.api.controller.v1;

import com.github.pagehelper.PageInfo;
import com.wx.testsercice.app.service.ProjectService;
import com.wx.testsercice.infra.dto.ProjectDTO;
import com.wx.testsercice.infra.dto.ProjectSearchDTO;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.constant.PageConstant;
import io.choerodon.base.enums.ResourceType;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/projects")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * 分页查询
     */
    @Permission(permissionPublic = true)
    @ApiOperation(value = "分页查询项目")
    @PostMapping(value = "/search")
    public ResponseEntity<PageInfo<ProjectDTO>> list(
            @RequestParam(defaultValue = PageConstant.PAGE, required = false) final int page,
            @RequestParam(defaultValue = PageConstant.SIZE, required = false) final int size,
            @RequestBody ProjectSearchDTO projectSearchDTO) {
        PageInfo<ProjectDTO> pageInfo = projectService.pagingQuery(page, size, projectSearchDTO);
        return new ResponseEntity<>(pageInfo, HttpStatus.OK);
    }
}

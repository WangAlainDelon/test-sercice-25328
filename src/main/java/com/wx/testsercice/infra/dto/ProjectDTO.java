package com.wx.testsercice.infra.dto;

import io.choerodon.mybatis.entity.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.persistence.*;
import java.util.List;

/**
 * @author superlee
 * @since 2019-04-22
 */
@Table(name = "fd_project")
public class ProjectDTO extends BaseDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键ID/非必填")
    private Long id;

    @ApiModelProperty(value = "项目名/必填")
    private String name;

    @ApiModelProperty(value = "项目编码/必填")
    private String code;

    @ApiParam(name = "organization_id", value = "组织id")
    @ApiModelProperty(value = "组织ID/非必填")
    private Long organizationId;

    @ApiModelProperty(value = "项目图标url")
    private String imageUrl;

    @ApiModelProperty(value = "是否启用/非必填")
    @Column(name = "is_enabled")
    private Boolean enabled;

    @ApiModelProperty(value = "项目类型code/非必填")
    private String type;
    @ApiModelProperty(value = "项目类型（遗留旧字段，一对一）:AGILE(敏捷项目),PROGRAM(普通项目组),ANALYTICAL(分析型项目群)")
    private String category;

    @ApiModelProperty(value = "项目类型(非开源，一对多)")
    private List<String> categories;


    @Transient
    private List<ProjectDTO> projects;

    @Transient
    @ApiModelProperty(value = "项目类型名称/非必填")
    private String typeName;
    @Transient
    private String organizationName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
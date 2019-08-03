package com.wx.testsercice.app.service.impl;

import com.wx.testsercice.app.service.OrganizationService;
import com.wx.testsercice.infra.dto.OrganizationDTO;
import com.wx.testsercice.infra.dto.ProjectDTO;
import com.wx.testsercice.infra.feign.OrganizationFeginClient;
import com.wx.testsercice.infra.mapper.OrganizationMapper;
import com.wx.testsercice.infra.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationMapper organizationMapper;
    private OrganizationFeginClient organizationFeginClient;
    private ProjectMapper projectMapper;

    public OrganizationServiceImpl(OrganizationFeginClient organizationFeginClient, OrganizationMapper organizationMapper, ProjectMapper projectMapper) {
        this.organizationFeginClient = organizationFeginClient;
        this.organizationMapper = organizationMapper;
        this.projectMapper = projectMapper;
    }

    /**
     * 根据id查询组织
     */
    @Override
    public OrganizationDTO queryOrganizationById(Long organization_id) {
        System.out.println("service层" + organization_id);
        OrganizationDTO query = organizationFeginClient.queryOrganizationById(organization_id);

        if (query != null) {
            organizationMapper.insert(query);
            //将项目插入数据库
            List<ProjectDTO> projects = query.getProjects();
            for (ProjectDTO project : projects) {
                projectMapper.insert(project);
            }
        }
        return query;
    }

    /**
     * 本服务的查询接口
     */
    @Override
    public OrganizationDTO querylocalOrganizationById(Long id) {
        return organizationMapper.selectByPrimaryKey(id);
    }
}

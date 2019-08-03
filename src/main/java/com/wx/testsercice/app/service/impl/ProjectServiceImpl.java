package com.wx.testsercice.app.service.impl;


import com.github.pagehelper.PageInfo;
import com.wx.testsercice.app.service.ProjectService;
import com.wx.testsercice.infra.dto.ProjectDTO;
import com.wx.testsercice.infra.dto.ProjectSearchDTO;
import com.wx.testsercice.infra.mapper.ProjectMapper;
import com.wx.testsercice.infra.repository.ProjectRepository;
import com.wx.testsercice.infra.utils.ParamUtils;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectMapper projectMapper;
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public PageInfo<ProjectDTO> pagingQuery(int page, int size, ProjectSearchDTO projectSearchDTO) {
        return projectRepository.pagingQuery(page, size, projectSearchDTO, ParamUtils.arrToStr(projectSearchDTO.getParam()));
    }
}

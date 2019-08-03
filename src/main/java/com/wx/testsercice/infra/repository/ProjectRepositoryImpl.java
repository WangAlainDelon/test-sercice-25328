package com.wx.testsercice.infra.repository;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.wx.testsercice.infra.dto.ProjectDTO;
import com.wx.testsercice.infra.dto.ProjectSearchDTO;
import com.wx.testsercice.infra.mapper.ProjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectRepositoryImpl implements ProjectRepository {
    private ProjectMapper projectMapper;

    public ProjectRepositoryImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public PageInfo<ProjectDTO> pagingQuery(int page, int size, ProjectSearchDTO projectSearchDTO, String param) {
        return PageHelper.startPage(page, size).doSelectPageInfo(() -> projectMapper.fulltextSearch(projectSearchDTO, param));
    }
}

package com.wx.testsercice.infra.repository;


import com.github.pagehelper.PageInfo;
import com.wx.testsercice.infra.dto.ProjectDTO;
import com.wx.testsercice.infra.dto.ProjectSearchDTO;

public interface ProjectRepository {
    PageInfo<ProjectDTO> pagingQuery(int page, int size, ProjectSearchDTO projectSearchDTO, String param);
}

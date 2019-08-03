package com.wx.testsercice.app.service;


import com.github.pagehelper.PageInfo;
import com.wx.testsercice.infra.dto.ProjectDTO;
import com.wx.testsercice.infra.dto.ProjectSearchDTO;

public interface ProjectService {
    PageInfo<ProjectDTO> pagingQuery(int page, int size, ProjectSearchDTO projectSearchDTO);
}

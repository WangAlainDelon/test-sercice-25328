package com.wx.testsercice.infra.mapper;

import com.wx.testsercice.infra.dto.ProjectDTO;
import com.wx.testsercice.infra.dto.ProjectSearchDTO;
import io.choerodon.mybatis.common.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper extends Mapper<ProjectDTO> {

    List<ProjectDTO> fulltextSearch(@Param("userSearchDTO") ProjectSearchDTO projectSearchDTO,
                                    @Param("param") String param);
}

package com.wx.testsercice.infra.mapper;


import com.wx.testsercice.infra.dto.OrganizationDTO;
import io.choerodon.mybatis.common.Mapper;

public interface OrganizationMapper extends Mapper<OrganizationDTO> {
    OrganizationDTO insertOrganization(OrganizationDTO organizationDTO);
}


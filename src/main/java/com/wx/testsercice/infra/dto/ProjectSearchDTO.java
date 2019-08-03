package com.wx.testsercice.infra.dto;

import io.swagger.annotations.ApiModelProperty;

public class ProjectSearchDTO extends ProjectDTO{
    @ApiModelProperty(value = "其他参数")
    private String[] param;

    public String[] getParam() {
        return param;
    }

    public void setParam(String[] param) {
        this.param = param;
    }
}

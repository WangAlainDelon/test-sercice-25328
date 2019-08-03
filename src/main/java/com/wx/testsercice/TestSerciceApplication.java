package com.wx.testsercice;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// 是否允许注册到注册中心，暂时注释掉
@EnableEurekaClient
// 是否开启猪齿鱼资源服务器
@EnableChoerodonResourceServer
@RestController
@EnableFeignClients("com.wx.testsercice")
@MapperScan("com.wx.testsercice.infra.mapper")
public class TestSerciceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSerciceApplication.class, args);
    }

}

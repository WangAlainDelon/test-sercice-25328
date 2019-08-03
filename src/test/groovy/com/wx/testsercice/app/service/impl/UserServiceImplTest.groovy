package com.wx.testsercice.app.service.impl

import com.wx.testsercice.app.service.UserService
import com.wx.testsercice.infra.dto.UserDTO
import io.choerodon.liquibase.LiquibaseConfig
import liquibase.Liquibase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Import
import spock.lang.Specification

/*测试创建user的功能*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConfiguration
@Import(IntegrationTestConfiguration)
class UserServiceImplTest extends Specification {

    @Autowired
    private UserService userService

    def "CreateOne"() {
        given: "构造请求参数"
        UserDTO userDTO = new UserDTO()
        userDTO.setEmployeeName("IronMan")
        userDTO.setEmail("shbchs@qq.com")
        userDTO.setEmployeeNumber("123")

        when: "调用方法"
        def entity = userService.createOne(userDTO)

        then: "校验参数"
        entity.getEmployeeName().equals(userDTO.getEmployeeName())
        entity.getEmployeeNumber().equals(userDTO.getEmployeeNumber())
        entity.getEmail().equals(userDTO.getEmail())
    }

}

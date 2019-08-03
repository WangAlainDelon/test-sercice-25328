package com.wx.testsercice.api.controller.v1

import com.wx.testsercice.app.service.impl.IntegrationTestConfiguration
import com.wx.testsercice.infra.dto.UserDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import spock.lang.Specification
import spock.lang.Stepwise

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(IntegrationTestConfiguration)
@Stepwise
class UserControllerTest extends Specification {
    private static String BASE_PATH = "/v1/users"

    @Autowired
    private TestRestTemplate restTemplate

    def "CreateOne"() {
        given: "构造请求参数"
        UserDTO userDTO = new UserDTO()
        userDTO.setEmployeeName("IronMan")
        userDTO.setEmail("shbchs@qq.com")
        userDTO.setEmployeeNumber("123")

        when: "调用方法"
        def entity = restTemplate.postForEntity(BASE_PATH,userDTO,UserDTO)

        then: "校验参数"
        entity.statusCode.is2xxSuccessful()
        entity.getBody().getEmployeeName().equals(userDTO.getEmployeeName())
        entity.getBody().getEmployeeNumber().equals(userDTO.getEmployeeNumber())
        entity.getBody().getEmail().equals(userDTO.getEmail())
    }

}

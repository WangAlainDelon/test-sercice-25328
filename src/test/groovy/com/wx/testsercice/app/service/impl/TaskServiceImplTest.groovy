package com.wx.testsercice.app.service.impl

import com.wx.testsercice.infra.dto.TaskDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Import
import spock.lang.Shared
import spock.lang.Specification
//测试taskservice的功能
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConfiguration
@Import(IntegrationTestConfiguration)
class TaskServiceImplTest extends Specification {
    @Shared
    private List<TaskDTO> taskDtoList = new ArrayList<>();


    def "CreateOne"() {
        given: "构造请求参数"
        TaskDTO taskDTO=new TaskDTO()
        taskDTO.setEmployeeId(1)
        taskDTO.setState("F/18")
        taskDTO.setTaskDescription("壮志凌云")
        taskDTO.setTaskNumber("熊猫")

        when: "调用方法"
        def entity = taskService.createOne(taskDTO)

        then: "校验参数"
        entity.getTaskDescription().equals(taskDTO.getTaskDescription())
        entity.getState().equals(taskDTO.getState())
        entity.getTaskNumber().equals(taskDTO.getTaskNumber())
        entity.getEmployeeId().equals(taskDTO.getEmployeeId())
    }

    def "QueryById"() {
        given: "构造参数"
        def Id=1;


    }

    def "QueryByTaskNumber"() {
    }

    def "Update"() {
    }

    def "DeleteById"() {
    }
}

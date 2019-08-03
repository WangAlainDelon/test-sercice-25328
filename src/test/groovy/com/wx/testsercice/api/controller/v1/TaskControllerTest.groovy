package com.wx.testsercice.api.controller.v1

import com.wx.testsercice.app.service.impl.IntegrationTestConfiguration
import com.wx.testsercice.infra.dto.TaskDTO

// 加入这段代码
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(IntegrationTestConfiguration)
@Stepwise
class TaskControllerTest extends Specification {
    private static String BASE_PATH = "/v1/tasks"

    @Autowired
    private TestRestTemplate restTemplate
   /* @Autowired
    private TaskMapper taskMapper*/
    @Shared
    def taskDTOS = new ArrayList<TaskDTO>()
    @Shared
    def needInit = true
    def count = 5
    def recount = 0
    @Shared
    def needClear = false

    def setup() {
        if (needInit) {
            given: "构造参数"
            needInit = false
            for (int i = 0; i < count; i++) {
                TaskDTO taskDTO = new TaskDTO()
                taskDTO.setEmployeeId(1)
                taskDTO.setState("F/18" + i)
                taskDTO.setTaskDescription("Good" + i)
                taskDTO.setTaskNumber("123" + i)
                taskDTOS.add(taskDTO)
            }
            when: "插入数据"
            for (int i = 0; i < count; i++) {
                def insert = taskMapper.insert(taskDTOS.get(i))
                recount = +insert
            }
            then: "校验参数"
            recount == count
        }

    }

    def cleanup() {
        if (needClear) {
            when: "调用方法"
            needClear = false
            def count = 0
            for (TaskDTO taskDTO : taskDTOS) {
                count += taskMapper.deleteByPrimaryKey(taskDTO)
            }

            then: "校验结果"
            count == 3
        }
    }


    def "Create"() {
        given: "构造请求参数"
        TaskDTO taskDTO = new TaskDTO()
        taskDTO.setEmployeeId(1)
        taskDTO.setState("F/18")
        taskDTO.setTaskDescription("壮志凌云")
        taskDTO.setTaskNumber("熊猫")

        when: "调用方法"
        def entity = restTemplate.postForEntity(BASE_PATH, taskDTO, TaskDTO)

        then: "校验参数"
        entity.statusCode.is2xxSuccessful()
        entity.getBody().getTaskDescription().equals(taskDTO.getTaskDescription())
        entity.getBody().getState().equals(taskDTO.getState())
        entity.getBody().getTaskNumber().equals(taskDTO.getTaskNumber())
        entity.getBody().getEmployeeId().equals(taskDTO.getEmployeeId())
    }

    def "QueryById"() {
        when: "调用对应方法"
        def entity = restTemplate.getForEntity(BASE_PATH + "/{id}", TaskDTO, 1L)
        //needClear = true

        then: "校验结果"
        entity.statusCode.is2xxSuccessful()
    }

    def "QueryByTaskNumber"() {
        when: "调用对应方法"
        def entity = restTemplate.getForEntity(BASE_PATH + "/taskNumber/{taskNumber}", TaskDTO, taskDTOS.get(2).getTaskNumber())
        //needClear = true

        then: "校验结果"
        entity.statusCode.is2xxSuccessful()

    }
    //更新的话需要设置版本号为1
    def "Update"() {
        given: "构造请求参数"
        def taskDTO = taskDTOS.get(1)

        taskDTO .setObjectVersionNumber(1L)
        taskDTO.setTaskDescription("壮志凌云2")
        when: "调用方法"

        restTemplate.put(BASE_PATH + "/{id}", taskDTO, taskDTO.getId())
        def entity = restTemplate.getForEntity(BASE_PATH + "/{id}", TaskDTO, taskDTO.getId())

        then: "校验结果"
        entity.statusCode.is2xxSuccessful()
        entity.getBody().getTaskDescription().equals(taskDTO.getTaskDescription())

    }

    def "Delete"() {
        given: "构造请求参数"
        def httpEntity = new HttpEntity<Object>()

        when: "调用对应方法"
        def entity = restTemplate.exchange(BASE_PATH + "/{id}", HttpMethod.DELETE, httpEntity, String, taskDTOS.get(0).getId())
        needClear = true
        then: "校验结果"
        entity.statusCode.is2xxSuccessful()
    }


}

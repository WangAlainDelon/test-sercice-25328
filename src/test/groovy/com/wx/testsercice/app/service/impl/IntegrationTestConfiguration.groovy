package com.wx.testsercice.app.service.impl


import io.choerodon.liquibase.LiquibaseConfig
import io.choerodon.liquibase.LiquibaseExecutor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration

import org.springframework.context.annotation.Import


import javax.annotation.PostConstruct

/**
 * @author dongfan117@gmail.com
 */
@TestConfiguration
@Import(LiquibaseConfig)
class IntegrationTestConfiguration {
    @Autowired
    LiquibaseExecutor liquibaseExecutor

    @PostConstruct
    void init() {
        liquibaseExecutor.execute()
    }

}

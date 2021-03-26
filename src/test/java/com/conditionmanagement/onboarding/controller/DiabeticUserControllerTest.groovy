package com.conditionmanagement.onboarding.controller

import com.conditionmanagement.onboarding.entity.DiabeticCondition
import com.conditionmanagement.onboarding.entity.DiabeticUser
import com.conditionmanagement.onboarding.entity.DiabetisType
import com.conditionmanagement.onboarding.service.DiabeticUserService
import org.mockito.Mock
import org.springframework.mock.web.MockHttpServletRequest
import spock.lang.Specification

import javax.servlet.http.HttpServletRequest

class DiabeticUserControllerTest extends Specification {

    DiabeticUserController controller
    @Mock
    HttpServletRequest request;

    void setup()
    {
        controller = new DiabeticUserController()
        controller.diabeticUserService = Mock(DiabeticUserService)


    }


    public void "savingDiabeticUser() is getting called exactly once"() {

        given:
        DiabeticUser sampleUser = new DiabeticUser( 2, "Swetha","123", DiabeticCondition.IHAVE,"22-05-2020", [DiabetisType.TYPE2])


        when:

        controller.savingDiabeticUser(sampleUser, request)


        then:
        1 * controller.diabeticUserService.saveDiabeticUser(sampleUser)

    }

    def "SaveDiabeticUser method is saving diabetic use details correctly"() {

        given:
        DiabeticUser sampleUser = new DiabeticUser( 2, "Swetha","123", DiabeticCondition.IHAVE,"22-05-2020", [DiabetisType.TYPE2])

        when:

        DiabeticUser result = controller.savingDiabeticUser(DiabeticUser, request)

        then:

        1 * controller.diabeticUserService.saveDiabeticUser(sampleUser) >> sampleUser

        result.getUserName() == sampleUser.getUserName()

    }
}

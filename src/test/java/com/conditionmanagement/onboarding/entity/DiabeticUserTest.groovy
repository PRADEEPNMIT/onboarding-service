package com.conditionmanagement.onboarding.entity

import spock.lang.Specification

/**
 * Unit test DiabeticUserTest entity.
 */
class DiabeticUserTest extends Specification {

    DiabeticUser diabeticUser = new DiabeticUser();

    def "should return diabetic user name"() {

        when:
        diabeticUser.setUserName(name)

        then:
        diabeticUser.getUserName().equals(expected)

        where:
        name              |    expected
        "SweeKarthik23"   |     "SweeKarthik23"
        "SKarthik21223"   |     "SKarthik21223"
        "SKarthik2123"    |     "SKarthik2123"

    }


}

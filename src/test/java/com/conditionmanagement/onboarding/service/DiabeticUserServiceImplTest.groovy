package com.conditionmanagement.onboarding.service

import com.conditionmanagement.onboarding.entity.DiabeticCondition
import com.conditionmanagement.onboarding.entity.DiabeticUser
import com.conditionmanagement.onboarding.entity.DiabetisType
import com.conditionmanagement.onboarding.repository.DiabeticUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import spock.lang.Specification

class DiabeticUserServiceImplTest extends Specification {

    def diabeticUserRepoMock = Mock(DiabeticUserRepository)

    def diabeticUserServiceImpl = new DiabeticUserServiceImpl(diabeticUserRepoMock)


    public void "findByuserName() is getting called exactly once"() {

        given:
            def userName = "SweeKarthik23"

        when:
        diabeticUserServiceImpl.findByUserName(userName)

        then:
        1 * diabeticUserRepoMock.findByUserName(userName)

    }

    public void "saveDiabeticUser() is getting called exactly once"() {

        given:

        DiabeticUser sampleUser = new DiabeticUser( 2, "Swetha","123", DiabeticCondition.IHAVE,"22-05-2020", [DiabetisType.TYPE2])

        when:
        diabeticUserServiceImpl.saveDiabeticUser(sampleUser)

        then:
        1 * diabeticUserRepoMock.save(sampleUser)

    }

    public void "Diabetic User getting saved correctly in db"() {


        given : "Diabetic user with all details"

        DiabeticUser sampleUser = new DiabeticUser( 2, "Swetha","123", DiabeticCondition.IHAVE,"22-05-2020", [DiabetisType.TYPE2])

        diabeticUserRepoMock.save(sampleUser) >> sampleUser


        when : "We register diabetic User"

        DiabeticUser result = diabeticUserRepoMock.save(sampleUser)

        then : "result values is same as sampleUser values"

        result.getUserId() == sampleUser.getUserId()
        result.getUserName() == sampleUser.getUserName()
        result.getPassword() == sampleUser.getPassword()
        result.getDiabeticCondition() == sampleUser.getDiabeticCondition()
        result.getDiabetisType() == sampleUser.getDiabetisType()
        result.getDiagonizedDate() == sampleUser.getDiagonizedDate()

    }



    public void "findByUsername returns username name if username exists in db"() {


        given : "Diabetic user with username"

        DiabeticUser sampleUser = new DiabeticUser()
        sampleUser.setUserName("Swetha")

        diabeticUserRepoMock.findByUserName(sampleUser.getUserName()) >> sampleUser

        when : "Find user by username method is called"

        DiabeticUser result = diabeticUserRepoMock.findByUserName(sampleUser.getUserName())


        then : "result values is same as sampleUser values"

        result.getUserName() == sampleUser.getUserName()


    }

    public void "findByUsername returns null if username does not exists in db"() {


        given : "Diabetic user with username as Swetha in db"

        DiabeticUser sampleUser = new DiabeticUser()
        sampleUser.setUserName("Swetha")

        diabeticUserRepoMock.findByUserName(sampleUser.getUserName()) >> sampleUser

        when : "Find user by username method is called"

        DiabeticUser result = diabeticUserRepoMock.findByUserName("Karthik")


        then : "result returns null as Karthik username not in db"

        result == null


    }


}

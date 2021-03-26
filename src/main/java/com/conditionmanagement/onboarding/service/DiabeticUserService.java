package com.conditionmanagement.onboarding.service;

import com.conditionmanagement.onboarding.entity.DiabeticUser;

public interface DiabeticUserService {

    DiabeticUser saveDiabeticUser(DiabeticUser diabeticUser);

    DiabeticUser findByUserName(String userName);

 //   boolean existUserByUsername(String userName);


    // DiabeticUser checkExistingUser(DiabeticUser diabeticUser);
}

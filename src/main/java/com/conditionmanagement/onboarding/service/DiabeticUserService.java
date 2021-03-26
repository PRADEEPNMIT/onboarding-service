package com.conditionmanagement.onboarding.service;

import com.conditionmanagement.onboarding.entity.DiabeticUser;

import java.util.Optional;

public interface DiabeticUserService {

    DiabeticUser saveDiabeticUser(DiabeticUser diabeticUser);

    DiabeticUser findByUserName(String userName);

    Optional<DiabeticUser> findById(long id);

    void deleteById(long id);

    //   boolean existUserByUsername(String userName);


    // DiabeticUser checkExistingUser(DiabeticUser diabeticUser);
}

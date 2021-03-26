package com.conditionmanagement.onboarding.service;

import com.conditionmanagement.onboarding.entity.DiabeticUser;
import com.conditionmanagement.onboarding.repository.DiabeticUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiabeticUserServiceImpl implements DiabeticUserService{

  //  @Autowired
    private DiabeticUserRepository diabeticUserRepository;

    //added for testing
    public DiabeticUserServiceImpl(DiabeticUserRepository diabeticUserRepository) {
        this.diabeticUserRepository = diabeticUserRepository;
    }


    @Override
    public DiabeticUser saveDiabeticUser(DiabeticUser diabeticUser) {

        return diabeticUserRepository.save(diabeticUser);

    }

     @Override
     public DiabeticUser findByUserName(String userName){

        return diabeticUserRepository.findByUserName(userName);
     }


}

package com.conditionmanagement.onboarding.controller;

import com.conditionmanagement.onboarding.entity.DiabeticUser;
import com.conditionmanagement.onboarding.http.header.HeaderGenerator;
import com.conditionmanagement.onboarding.service.DiabeticUserService;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/diabeticUsers")
public class DiabeticUserController {

   // @Autowired
    private DiabeticUserService diabeticUserService;

    public DiabeticUserController(DiabeticUserService diabeticUserService)
    {
        this.diabeticUserService = diabeticUserService;
    }

    @Autowired
    private HeaderGenerator headerGenerator;

    @PostMapping("/")
    public ResponseEntity<DiabeticUser> savingDiabeticUser(@RequestBody DiabeticUser diabeticUser, HttpServletRequest request) {

        if (diabeticUser != null)
            try {

                if(isUsernameExist(diabeticUser.getUserName())) {
                    DiabeticUser newUser = diabeticUserService.saveDiabeticUser(diabeticUser);
                    //return new ResponseEntity<DiabeticUser>(
                       //     diabeticUser,
                         //   headerGenerator.getHeadersForSuccessPostMethod(request, diabeticUser.getUserId()),
                         //   HttpStatus.CREATED);

                    return ResponseEntity.created(new URI("/"+diabeticUser.getUserName()))
                                        .eTag(newUser.getUserName()+"got added")
                                         .body(newUser);

                }

                else {
                    System.out.println("Username already exists. Try registering with another name");
                  // return new ResponseEntity<DiabeticUser>(
                    //             headerGenerator.getHeadersForError(),
                      //         HttpStatus.INTERNAL_SERVER_ERROR);


                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

                }

            }

        catch (Exception e) {
                e.printStackTrace();

                return new ResponseEntity<DiabeticUser>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        System.out.println("Duplicate " + HttpStatus.BAD_REQUEST);
        return new ResponseEntity<DiabeticUser>(HttpStatus.BAD_REQUEST);

    }

    public boolean isUsernameExist(String userName) {

        DiabeticUser existingDiabeticUser2 = diabeticUserService.findByUserName(userName);

        if (existingDiabeticUser2 == null) {
            return true;
        }
        return false;
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteDiabeticUser(@PathVariable long id, HttpServletRequest request) {

        if (id != 0) {
            Optional<DiabeticUser> existingDiabeticUser2 = diabeticUserService.findById(id);
            if(existingDiabeticUser2.isPresent()){
                diabeticUserService.deleteById(id);
            }
            return ResponseEntity.ok().build().toString();
        }
            return null;
    }
}
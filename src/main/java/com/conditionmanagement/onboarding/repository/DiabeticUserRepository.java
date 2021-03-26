package com.conditionmanagement.onboarding.repository;

import com.conditionmanagement.onboarding.entity.DiabeticUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiabeticUserRepository extends JpaRepository<DiabeticUser,Long> {

  //  DiabeticUser findDiabeticUserName(String userName);
 // @Query("SELECT u FROM users_table u WHERE u.user_name = ?1")

  DiabeticUser findByUserName(String userName);

}

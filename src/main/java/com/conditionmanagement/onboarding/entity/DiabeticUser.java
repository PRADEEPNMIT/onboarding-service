package com.conditionmanagement.onboarding.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "users_table_latest")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiabeticUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    @Column (name = "user_name", nullable = false, unique = true, length = 50)
    private String userName;

    @Column (name = "user_password", nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column (name = "diabetic_condition", nullable = false, length = 50)
    private DiabeticCondition diabeticCondition;

    @Column (name = "diagonized_date", length = 50)
    private String diagonizedDate;

   @ElementCollection
   @CollectionTable(name = "my_diabetis_list", joinColumns = @JoinColumn(name = "userId"))
   @Enumerated(EnumType.STRING)
   @Column(name = "diabetis_type")
   private List<DiabetisType> diabetisType;


}

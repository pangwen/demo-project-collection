package com.pangw.sharding.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Random;

/**
 * user entity
 */
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 8484153412731198311L;

    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private LocalDate birth;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


    private final Random random = new Random();
    private final String[] genders = {"F", "M"};
    private final String strs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public void randomUser( ){
        this.setName(randomName());
        this.setAge(randomAge());
        this.setGender(randomGender());
        this.setBirth(randomBirth(getAge()));
    }



    private String randomName(){
        int len = 20;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(strs.charAt(random.nextInt(strs.length() - 1)));
        }
        return sb.toString();

    }

    private int randomAge(){
        return random.nextInt(40) + 10;
    }



    private String randomGender(){
        return genders[getAge() % 2];
    }

    private LocalDate randomBirth(int age){
        int year = Year.now().getValue() - age;
        int month = random.nextInt(11) + 1;
        int day = random.nextInt(27) + 1;

        return LocalDate.of(year, month, day);
    }
}

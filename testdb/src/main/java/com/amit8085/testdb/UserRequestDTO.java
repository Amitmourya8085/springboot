package com.amit8085.testdb;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.mapping.Value;

public class UserRequestDTO {
    @NotBlank(message = "Name can not be empty")
    private String name;

    @Min(value = -1,message = "age must be greater than 0")
    private int age;

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }
}

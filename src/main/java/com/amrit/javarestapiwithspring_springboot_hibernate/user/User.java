package com.amrit.javarestapiwithspring_springboot_hibernate.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name="details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Enter at least 2 characters")// min size of the name should be 2
    //@JsonProperty("user_name")// used to change the name of the field
    private String name;

    @Past(message = "Birth date should be in the past") // birthdate should always be in past
    private LocalDate birthDate;

    public User(){}
    public User(Integer id,String name,LocalDate birthDate){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }


}

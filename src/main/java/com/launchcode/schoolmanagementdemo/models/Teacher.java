package com.launchcode.schoolmanagementdemo.models;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Teacher extends AbstractEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private PersonalDetails personalDetails;

    private Gender gender;

    @ManyToOne
    @NotNull(message = "class is required")
    private Classes classes;

    public Teacher (){
    }

    public Teacher(Gender gender, Classes classes) {
        this.gender = gender;
        this.classes = classes;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}

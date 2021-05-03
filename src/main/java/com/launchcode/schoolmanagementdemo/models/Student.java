package com.launchcode.schoolmanagementdemo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Student extends AbstractEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private PersonalDetails personalDetails;
    @Valid
    @NotNull
    private Gender gender;

    private String schoolYear;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private Classes classes;

    public Student(){

    }

    public Student( Gender gender, String schoolYear, Classes classes) {
        this.gender = gender;
        this.schoolYear = schoolYear;
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

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "personalDetails=" + personalDetails +
                ", gender=" + gender +
                ", classes=" + classes +
                '}';
    }
}

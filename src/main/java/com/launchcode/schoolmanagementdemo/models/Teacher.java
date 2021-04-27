package com.launchcode.schoolmanagementdemo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Teacher extends AbstractEntity{
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private PersonalDetails personalDetails;

    @Size(min=1, max=6 ,message = "At least One Checkbox must be checked")
    private String classesTeach;

    public Teacher (){
    }

    public Teacher(String classesTeach) {
        this.classesTeach = classesTeach;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public String getClassesTeach() {
        return classesTeach;
    }

    public void setClassesTeach(String classesTeach) {
        this.classesTeach = classesTeach;
    }

}

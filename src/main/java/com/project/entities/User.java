package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

import java.util.Date;

@Entity
public class User {
    @Id
    @NonVisual
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Validate("required,minLength=3,maxLength=15")
    public String firstName;

    @Validate("required,minLength=3,maxLength=15")
    public String lastName;

    //// TODO: 11.04.16  change validate
    @Validate("required,minLength=3,maxLength=15")
    public String telephoneNumber;

    @Validate("required,minLength=3,maxLength=15")
    public String emailAddress;

    @Validate("required")
    public Date birthDate;

    @Validate("required,minLength=3,maxLength=15")
    public String password;

}



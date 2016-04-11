package com.project.entities;

import org.apache.tapestry5.beaneditor.Validate;

import javax.persistence.Entity;

@Entity
public class Dentist extends User {

    @Validate("required,minLength=10,maxLength=80")
    public String address;
    
    //// TODO: 11.04.16 kalendarz cokolwiek to jest, wiadomosci i opinie
}

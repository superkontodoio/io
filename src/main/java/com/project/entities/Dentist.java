package com.project.entities;

import org.apache.tapestry5.beaneditor.Validate;

import javax.persistence.Entity;

/**
 * <h1>User</h1>
 *  Rozszerza klase użytkownika o dodatkowe pole - adres gabinetu.
 *
 *
 * @author  Jakub Kwiatkowski
 * @version 1.0
 * @since   2016-04-13
 */
@Entity
public class Dentist extends User {

    /**
     * Adres gabinetu.
     */
    @Validate("required,minLength=10,maxLength=80")
    public String address;
    
    //// TODO: 11.04.16 kalendarz cokolwiek to jest, wiadomosci i opinie
}

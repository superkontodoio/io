package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

import java.util.Date;

/**
 * <h1>User</h1>
 * Klasa implementująca konto w serwisie dla stomatologa.
 *
 *
 * @author  Jakub Kwiatkowski
 * @version 1.0
 * @since   2016-04-13
 */
@Entity
public class User {
    /**
     * Id użytkownika.
     */
    @Id
    @NonVisual
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * Imię użytkownika.
     */
    @Validate("required,minLength=3,maxLength=15")
    public String firstName;

    /**
     * Nazwisko użytkownika.
     */
    @Validate("required,minLength=3,maxLength=15")
    public String lastName;

    //// TODO: 11.04.16  change validate
    /**
     * Numer telfonu użytkownika.
     */
    @Validate("required,minLength=3,maxLength=15")
    public String telephoneNumber;

    /**
     *  Adres email użytkownika.
     */
    @Validate("required,minLength=3,maxLength=15")
    public String emailAddress;

    /**
     *   Data urodzenia użytkownika.
     */
    @Validate("required")
    public Date birthDate;

    /**
     *   Hasło użytkownika.
     */
    @Validate("required,minLength=3,maxLength=15")
    public String password;

}



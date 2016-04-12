package com.project.session;

import com.project.entities.Dentist;

import java.io.Serializable;


/**
 * <h1>DentistVisit</h1>
 * Klasa przechowująca dane użytkownika w sesji.
 *
 *
 * @author  Malgorzata Fadziel
 * @version 1.0
 * @since   2016-04-13
 */
@SuppressWarnings("serial")
public class DentistVisit implements Serializable {

    /**
     *  Id użytkownika.
     */
    private Long userId = null;

    /**
     *  Adres email użytkownika.
     */
    private String userEmail = null;

    /**
     * @param dentist Klasa użytkownika, którą będzie przechowywała sesja.
     */
    public DentistVisit(Dentist dentist) {
        userId = dentist.id;
        userEmail = dentist.emailAddress;

    }

    /**
     * {@link DentistVisit#userId}
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * {@link DentistVisit#userEmail}
     */
    public String getUserEmail() {
        return userEmail;
    }
}



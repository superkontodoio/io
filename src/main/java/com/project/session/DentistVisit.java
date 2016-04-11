package com.project.session;

import com.project.entities.Dentist;

import java.io.Serializable;



@SuppressWarnings("serial")
public class DentistVisit implements Serializable {

    private Long userId = null;
    private String userEmail = null;

    public DentistVisit(Dentist dentist) {
        userId = dentist.id;
        userEmail = dentist.emailAddress;

//        cacheUsefulStuff(dentist);
    }
//
//    public void noteChanges(User user) {
//        if (user == null) {
//            throw new IllegalArgumentException();
//        }
//        else if (user.getId().equals(myUserId)) {
//            cacheUsefulStuff(user);
//        }
//    }
//
//    private void cacheUsefulStuff(User user) {
//        userEmail = user.getLoginId();
//        pageStyle = user.getPageStyle();
//        dateInputPattern = user.getDateInputPattern();
//        dateViewPattern = user.getDateViewPattern();
//        dateListPattern = user.getDateListPattern();
//    }

    public Long getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }
}



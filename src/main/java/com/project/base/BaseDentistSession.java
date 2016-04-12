package com.project.base;

import com.project.session.DentistVisit;
import org.apache.tapestry5.annotations.SessionAttribute;
import org.apache.tapestry5.annotations.SessionState;

public class BaseDentistSession {
    @SessionState
    protected DentistVisit dentistVisit;

    protected boolean dentistVisitExists;

    public DentistVisit getDentistVisit() {
        return dentistVisit;
    }

    public void setDentistVisit(DentistVisit visit) {
        this.dentistVisit = visit;
    }

    public boolean isDentistVisitExists() {
        return dentistVisitExists;
    }
}

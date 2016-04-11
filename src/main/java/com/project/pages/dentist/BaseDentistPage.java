package com.project.pages.dentist;

import com.project.entities.Dentist;
import com.project.session.DentistVisit;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

public class BaseDentistPage {
    @SessionState
    private DentistVisit visit;
    private boolean visitExists;


    @Property
    private Dentist dentist;

    @Inject
    private Session session;

    public DentistVisit getDentistVisit() {
        return visit;
    }

    protected void setDentistVisit(DentistVisit visit) {
        this.visit = visit;
    }

    public boolean isDentistVisitExists() {
        return visitExists;
    }

    void setupRender() {
        if (!visitExists)return;
         dentist = (Dentist) session.get(Dentist.class, visit.getUserId());
    }
}

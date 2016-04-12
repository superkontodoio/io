package com.project.pages.dentist;

import com.project.entities.Dentist;
import com.project.base.BaseDentistSession;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

public class BaseDentistPage extends BaseDentistSession {

    @Property
    protected Dentist dentist;

    @Inject
    protected Session session;

    @Log
    void setupRender() {
        if (!isDentistVisitExists())return;
         dentist = (Dentist) session.get(Dentist.class, getDentistVisit().getUserId());
    }
}

package com.project.pages.dentist;

import com.project.entities.Dentist;
import com.project.base.BaseDentistSession;
import com.project.pages.Index;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.omg.PortableInterceptor.INACTIVE;

public class BaseDentistPage extends BaseDentistSession {

    @Property
    protected Dentist dentist;

    @Inject
    protected Session session;

    //// TODO: 12.04.16 without session go index
    @Log
    void setupRender() {
        if (!isDentistVisitExists()) return;
         dentist = (Dentist) session.get(Dentist.class, getDentistVisit().getUserId());
    }

//    Object goIndex(){
//        return Index.class;
//    }
}

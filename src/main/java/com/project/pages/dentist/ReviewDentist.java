package com.project.pages.dentist;

import com.project.entities.Dentist;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class ReviewDentist extends BaseDentistPage {
    @Property
    @Persist
    private Dentist reviewDentist;

    @Property
    private Long target;
    Long onPassivate() {
        return target;
    }

    void onActivate(Long target) {
        this.target = target;
    }

    void setupRender() {
        reviewDentist = (Dentist) session.get(Dentist.class, target);
    }


}

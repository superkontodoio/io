package com.project.pages.dentist;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;

public class EditDentist extends BaseDentistPage {

    @InjectComponent
    private BeanEditForm editForm;


    @CommitAfter
    void onValidateFromEditForm() {
        if (editForm.getHasErrors()) {
            return;
        }
        session.update(dentist);
    }

}

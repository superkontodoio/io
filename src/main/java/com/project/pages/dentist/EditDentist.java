package com.project.pages.dentist;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;

/**
 * <h1>Edit Dentist</h1>
 * Pozwala na edytowanie danych stomatologa.
 *
 *
 * @author  Przemysław Rydzyk
 * @version 1.0
 * @since   2016-04-13
 */
public class EditDentist extends BaseDentistPage {



    /**
     *  Formularz do edycji danych.
     */
    @InjectComponent
    private BeanEditForm editForm;

    /**
     * Zapisuje nowe dane do bazy danych.
     */
    @CommitAfter
    void onValidateFromEditForm() {
        if (editForm.getHasErrors()) {
            return;
        }
        session.update(dentist);
    }

}

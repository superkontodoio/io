package com.project.pages.dentist;

import com.project.entities.Dentist;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ShowDentist  extends BaseDentistPage{
    @InjectComponent
    private Zone dentistsZone;

    @Inject
    private Request request;

    @Property
    private String searchValue;

    public List<Dentist> getDentists() {
        Criteria criteria = session.createCriteria(Dentist.class);
        if (searchValue != null) {

            Criterion firstName = Restrictions.ilike("firstName", searchValue);
            Criterion lastName = Restrictions.ilike("lastName", searchValue);
            Criterion address = Restrictions.ilike("address", searchValue);
            Criterion addressEmail = Restrictions.ilike("emailAddress", searchValue);
            Criterion telephoneNumber = Restrictions.ilike("telephoneNumber", searchValue);

            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date searchDate = null;
            try {
                searchDate = format.parse(searchValue);
            } catch (ParseException e) {
            }
            Criterion birthDate = Restrictions.eq("birthDate", searchDate);
            Disjunction orExp = Restrictions.or(firstName,lastName,address,addressEmail,telephoneNumber,birthDate);

            criteria.add(orExp);
        }
        return criteria.list();
    }
    Object onSuccess() {
        return request.isXHR() ? dentistsZone.getBody() : null;
    }

    Object onFailure() {
        return request.isXHR() ? dentistsZone.getBody() : null;
    }

    String onPassivate() {
        return searchValue;
    }

    void onActivate(String searchValue) {
        this.searchValue = searchValue;
    }



}

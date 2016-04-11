package com.project.pages.dentist;

        import com.project.entities.Dentist;
        import com.project.pages.Index;
        import org.apache.tapestry5.alerts.AlertManager;
        import org.apache.tapestry5.annotations.InjectPage;
        import org.apache.tapestry5.annotations.Property;
        import org.apache.tapestry5.hibernate.annotations.CommitAfter;
        import org.apache.tapestry5.ioc.annotations.Inject;
        import org.hibernate.Session;
        import org.slf4j.Logger;


public class CreateDentist {
    @Property
    private Dentist dentist;

    @Inject
    private Session session;

    @InjectPage
    private Index index;

    @Inject
    private Logger logger;

    @Inject
    private AlertManager alertManager;


    //// TODO: 11.04.16 repeat password

    @CommitAfter
    Object onSuccess() {
        session.persist(dentist);
        logger.info("Register successful!");
        alertManager.success("Welcome aboard!");
        return index;
    }

    void onFailure()
    {
        logger.warn("Register error!");
        alertManager.error("I'm sorry but I can't log you in!");
    }

}


package com.project.pages;

import com.project.entities.Dentist;
import com.project.pages.dentist.WelcomeDentist;
import com.project.base.BaseDentistSession;
import com.project.session.DentistVisit;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;

import java.util.List;

public class Login extends BaseDentistSession
{
  @Inject
  private Session session;

  @Inject
  private Logger logger;

  @Inject
  private AlertManager alertManager;

  @InjectComponent
  private Form login;
  
  @InjectComponent("email")
  private TextField emailField;
  
  @InjectComponent("password")
  private PasswordField passwordField;

  @Property
  private String email;

  @Property
  private String password;

  public List<Dentist> getDentists() {
    Criteria criteria = session.createCriteria(Dentist.class);
    criteria.add(Restrictions.eq("emailAddress", email));
    criteria.add(Restrictions.eq("password", password));
    return criteria.list();
  }


  //todo change
  //// TODO: 11.04.16 onFail
  void onValidateFromLogin()
  {
    if (login.getHasErrors()) {
      return;
    }

  }

  Object onSuccessFromLogin()
  {
    List<Dentist> loginResult = getDentists();
    if (loginResult.size() != 1) {
      logger.warn("Login error!");
      alertManager.error("Incorrect email or password.");
      return this.getClass();
    }
    logger.info("Login successful!");
    alertManager.success("Welcome aboard!");
    Dentist dentist = loginResult.get(0);
    setDentistVisit(new DentistVisit(dentist));
    return WelcomeDentist.class;
  }

  void onFailureFromLogin()
  {
    logger.warn("Login error!");
    alertManager.error("I'm sorry but I can't log you in!");
  }

}

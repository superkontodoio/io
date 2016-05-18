package com.project.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;

/**
 * <h1>User</h1>
 *  Rozszerza klase u�ytkownika o list� um�wionych spotka�
 *
 *
 * @author  Przemys�aw Rydzyk
 * @version 1.0
 * @since   2016-05-18
 */
@Entity
public class Patient extends User {

    /**
     * Lista um�wionych spotka�
     */
    private ArrayList appointments;
    
    public String przedstawSie(){
    	return "Cze��! Jestem " + this.firstName;
    }
    
    public int podajWiek(){
    	int y = 2016;
    	@SuppressWarnings("deprecation")
		int w = this.birthDate.getYear();
    	return y - w;
    }
}

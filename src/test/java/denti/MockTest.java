package denti;

import org.testng.annotations.Test;

import com.project.entities.*;
import org.mockito.Mockito;

import org.testng.Assert;

/**
 *  Tworzy obiekt testowy - mock
 *
 *
 * @author  Przemys³aw Rydzyk
 * @version 1.0
 * @since   2016-05-18
 */

public class MockTest extends Assert{
	
	@Test
	public void Test(){
		Patient testpatient = Mockito.mock(Patient.class); 
		Mockito.when(testpatient.podajWiek()).thenReturn(15);
		System.out.println(testpatient.podajWiek());
		Mockito.verify(testpatient).podajWiek();
	}
}


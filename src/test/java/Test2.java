import com.project.entities.*;
import org.testng.annotations.*;
import org.mockito.Mockito;

import org.testng.Assert;

public class Test2 extends Assert{
	
	@Test
	public void Test(){
		Patient testpatient = Mockito.mock(Patient.class); 
		Mockito.when(testpatient.podajWiek()).thenReturn(15);
		testpatient.podajWiek();
		Mockito.verify(testpatient).podajWiek();		
	}
}


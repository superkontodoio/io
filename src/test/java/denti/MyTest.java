package denti;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;
import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.test.PageTester;
import org.testng.annotations.Test;

public class MyTest {
	  public PageTester createNewTester() {
	      String appPackage = "com.project";
	      String appName = "";
	      return new PageTester(appPackage, appName, "src/main/webapp");
	  }
	  
	  @Test
	  public void testIsDentistLink() {
		  PageTester tester = createNewTester();
		  Document doc = tester.renderPage("Index");
		  assertTrue(doc.getElementById("dentistLink").toString().contains("Create Dentist Account"));
	  }
	  
	  @Test
	  public void testIsPatientLink() {
		  PageTester tester = createNewTester();
		  Document doc = tester.renderPage("Index");
		  assertTrue(doc.getElementById("patientLink").toString().contains("Create Patient Account"));
	  }
	  
	  @Test
	  public void testTargetDentistLink() {
		  PageTester tester = createNewTester();
		  Document doc = tester.renderPage("Index");
		  Element link = doc.getElementById("dentistLink");
		  doc = tester.clickLink(link);
		  assertTrue(doc.toString().contains("<title>Create New Dentist Account"));
	  }
	  
	  @Test
	  public void testTargetPatientLink() {
		  PageTester tester = createNewTester();
		  Document doc = tester.renderPage("Index");
		  Element link = doc.getElementById("patientLink");
		  doc = tester.clickLink(link);
		  assertTrue(doc.toString().contains("<title>Create New Patient Account"));
	  }
	  
	  @Test
	  public void testIsSignInButton() {
		  PageTester tester = createNewTester();
		  Document doc = tester.renderPage("Index");
		  assertNotNull(doc.getElementById("signInBtn"));
	  }
	  
	  

}

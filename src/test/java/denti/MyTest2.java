package denti;

import java.util.HashMap;
import java.util.Map;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.test.PageTester;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest2 extends Assert{
	public PageTester createNewTester() {
	      String appPackage = "com.project";
	      String appName = "";
	      return new PageTester(appPackage, appName, "src/main/webapp");
	  }
	@Test (enabled = false)
	public void testPatientLinkOnShowDentistPage(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("ShowDentist");
		assertTrue(doc.getElementById("patientLink").toString().contains("patient/create"));
	  }
	@Test (enabled = false)
	public void testLoginForm(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Login");
		Element form = doc.getElementById("login");
		Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put("email", "op@op.pl");
        fieldValues.put("password", "op@op.pl");
        doc = tester.submitForm(form, fieldValues);
        assertTrue(doc.toString().contains("Witaj,"));
	  }
	@Test (enabled = false)
	public void testError404PageContent(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		//System.out.println("//\n//\n//\n//");
		//System.out.println(doc.toString());
		assertTrue(doc.getElementById("unfortunately").toString().contains("znaleziona"));
	}
	@Test (enabled = false)
	public void testError404PageContent2(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		assertTrue(doc.getElementById("options").toString().contains("strony"));
	}
	@Test (enabled = false)
	public void testError404PageLink(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		Element link = doc.getElementById("linkToMain");
		doc = tester.clickLink(link);
		assertTrue(doc.toString().contains("Create"));
	}
	@Test (enabled = false)
	public void testDentistLinkOnShowDentistPage(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("ShowDentist");
		assertTrue(doc.getElementById("dentistLink").toString().contains("/dentist/create"));
	}
	
	@Test //(enabled = false)
	public void testCreateDentistForm(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("CreateDentist");
		Element form = doc.getElementById("form");
		Map<String, String > fieldValues = new HashMap<String, String>();
        fieldValues.put("firstName", "Janusz");
        fieldValues.put("lastName", "Testowy");
        fieldValues.put("address", "Testowa 17/2 Poznañ");
        fieldValues.put("emailAddress", "janusz@januszowo.eu");
        fieldValues.put("telephoneNumber", "723 923 637");
        fieldValues.put("birthDate", "11/1/1971");
        fieldValues.put("password", "password");
        System.out.println("//\n//\n//\n//");
		System.out.println(doc.toString());
        doc = tester.submitForm(form, fieldValues);
        assertTrue(doc.toString().contains("Create"));
	  }
	
	
}

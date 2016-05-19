package denti;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.test.PageTester;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *  <h1>Assert</h1>
 *  Test Cases - Testing form component (display and submission)
 *
 * @author  Ma³gorzata F¹dziel
 * @version 1.0
 * @since   2016-05-18
 */

public class TestCreateForm {
	private PageTester tester;

	@BeforeClass
	public void setUp() {
		String appPackage = "com.project";
		String appName = "";
		tester = new PageTester(appPackage, appName, "src/main/webapp");
	}

	@AfterClass
	public void shutdown() {
		tester.shutdown();
	}

	@Test
	public void testIsForm() {
		Document doc = tester.renderPage("dentist/CreateDentist");		
		assertNotNull(doc.getElementById("form"));
	}

	@Test
	public void testFormFieldFirstName() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		assertNotNull(form.getElementByAttributeValue("for", "firstName"));
	}
	
	@Test
	public void testFormFieldLastName() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		assertNotNull(form.getElementByAttributeValue("for", "lastName"));
	}
	
	@Test
	public void testFormFieldAddress() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		assertNotNull(form.getElementByAttributeValue("for", "address"));
	}
	
	@Test
	public void testFormFieldEmailAddress() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		assertNotNull(form.getElementByAttributeValue("for", "emailAddress"));
	}
	
	@Test
	public void testFormFieldTelephoneNumber() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		assertNotNull(form.getElementByAttributeValue("for", "telephoneNumber"));
	}
	
	@Test
	public void testFormFieldBirthDate() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		assertNotNull(form.getElementByAttributeValue("for", "birthDate"));
	}
	
	@Test
	public void testFormFieldPassword() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		assertNotNull(form.getElementByAttributeValue("for", "password"));
	}
	
	@Test
	public void testFormCorrectSubmit() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		
		Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put("firstName", "Anna");
        fieldValues.put("lastName", "Dereszowska");
        fieldValues.put("address", "ul.Piotrowo 2 , 60-094 Poznañ");
        fieldValues.put("emailAddress", "anna@buziaczek.pl");
        fieldValues.put("telephoneNumber", "946723815");
        fieldValues.put("birthDate", "5/11/1972");
        fieldValues.put("password", "asdf");
        doc = tester.submitForm(form, fieldValues);
        assertTrue(doc.toString().contains("Welcome aboard"));
	}
	
	@Test
	public void testFormIncorrectSubmit() {
		Document doc = tester.renderPage("dentist/CreateDentist");
		Element form = doc.getElementById("form");
		
		Map<String, String> fieldValues = new HashMap<String, String>();
        doc = tester.submitForm(form, fieldValues);
        assertFalse(doc.toString().contains("Welcome aboard"));
	}
}

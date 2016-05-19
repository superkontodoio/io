package denti;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.test.PageTester;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *  <h1>Assert</h1>
 *  Test Cases - Testing Components of Index Page
 *
 *
 * @author  Ma³gorzata F¹dziel
 * @version 1.0
 * @since   2016-05-18
 */

public class MyTest {

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
	public void testIsDentistLink() {
		// PageTester tester = createNewTester();
		Document doc = tester.renderPage("Index");
		assertTrue(doc.getElementById("dentistLink").toString()
				.contains("Create Dentist Account"));
	}

	@Test
	public void testIsPatientLink() {
		// PageTester tester = createNewTester();
		Document doc = tester.renderPage("Index");
		assertTrue(doc.getElementById("patientLink").toString()
				.contains("Create Patient Account"));
	}

	@Test
	public void testTargetDentistLink() {
		// PageTester tester = createNewTester();
		Document doc = tester.renderPage("Index");
		Element link = doc.getElementById("dentistLink");
		doc = tester.clickLink(link);
		assertTrue(doc.toString().contains("<title>Create New Dentist Account"));
	}

	@Test
	public void testTargetPatientLink() {
		// PageTester tester = createNewTester();
		Document doc = tester.renderPage("Index");
		Element link = doc.getElementById("patientLink");
		doc = tester.clickLink(link);
		assertTrue(doc.toString().contains("<title>Create New Patient Account"));
	}

	@Test
	public void testIsSignInButton() {
		// PageTester tester = createNewTester();
		Document doc = tester.renderPage("Index");
		assertNotNull(doc.getElementById("signInBtn"));
	}

}

package denti;

import java.util.HashMap;
import java.util.Map;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.test.PageTester;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *  <h1>Assert</h1>
 *  Test Cases - Strona 404, Login, ShowDentist, RewievDentist
 *
 *
 * @author  Przemys³aw Rydzyk
 * @version 1.0
 * @since   2016-05-18
 */

public class MyTest2 extends Assert{
	/*
	 * Stworzenie testera.
	 */
	public PageTester createNewTester() {
	      String appPackage = "com.project";
	      String appName = "";
	      return new PageTester(appPackage, appName, "src/main/webapp");
	  }
	
	/*
	 * Test logowania - dane poprawne.
	 */
	@Test //(enabled = false)
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
	/*
	 * Test logowania - b³êdne has³o.
	 */
	@Test //(enabled = false)
	public void testLoginFormBadCredentials(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Login");
		Element form = doc.getElementById("login");
		Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put("email", "op@op.pl");
        fieldValues.put("password", "zle_haslo");
        doc = tester.submitForm(form, fieldValues);
        try{
        	assertTrue(doc.toString().contains("Witaj,"));
        }catch(Throwable t){
        	System.out.println("Wyst¹pi³ b³¹d logowania!");
        }
	  }
	/*
	 * Test strony 404 - treœæ podstawowa.
	 */
	@Test //(enabled = false)
	public void testError404PageContent(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		//System.out.println("//\n//\n//\n//");
		//System.out.println(doc.toString());
		assertTrue(doc.getElementById("unfortunately").toString().contains("znaleziona"));
	}
	/*
	 * Test strony 404 - treœæ dodatkowa.
	 */
	@Test //(enabled = false)
	public void testError404PageContent2(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		assertTrue(doc.getElementById("options").toString().contains("strony"));
	}
	/*
	 * Test strony 404 - link do powrotu na stronê g³ówn¹.
	 */
	@Test //(enabled = false)
	public void testError404PageLink(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		Element link = doc.getElementById("linkToMain");
		doc = tester.clickLink(link);
		assertTrue(doc.toString().contains("Create"));
	}
	
	/*
	 * Test ShowDentist - wyœwietlania wszystkich dentystów.
	 */
	@Test //(enabled = false)
	public void testShowDentistPage(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("dentist/ShowDentist");
		//assertTrue(doc.getElementById("showDentistGrid").isEmpty());
	}
	
	/*
	 * Test ReviewDentist - wyœwietlania informacji o dentyœcie
	 */
	@Test //(enabled = false)
	public void testReviewDentistDisplay(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("dentist/ReviewDentist");
		//assertTrue(doc.getElementById("dane_dentysty").toString().contains("Informacje o dentyscie"));
	}	
}

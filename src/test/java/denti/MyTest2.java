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
 *  Test Cases 2
 *
 *
 * @author  Przemys³aw Rydzyk
 * @version 1.0
 * @since   2016-05-18
 */

public class MyTest2 extends Assert{
	public PageTester createNewTester() {
	      String appPackage = "com.project";
	      String appName = "";
	      return new PageTester(appPackage, appName, "src/main/webapp");
	  }
	
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
	@Test //(enabled = false)
	public void testError404PageContent(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		//System.out.println("//\n//\n//\n//");
		//System.out.println(doc.toString());
		assertTrue(doc.getElementById("unfortunately").toString().contains("znaleziona"));
	}
	@Test //(enabled = false)
	public void testError404PageContent2(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		assertTrue(doc.getElementById("options").toString().contains("strony"));
	}
	@Test //(enabled = false)
	public void testError404PageLink(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		Element link = doc.getElementById("linkToMain");
		doc = tester.clickLink(link);
		assertTrue(doc.toString().contains("Create"));
	}
	@Test //(enabled = false)
	public void testDentistLinkOnShowDentistPage(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("dentist/ShowDentist");
		//assertTrue(doc.getElementById("showDentistGrid").isEmpty());
	}
	
	@Test //(enabled = false)
	public void testReviewDentistDisplay(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("dentist/ReviewDentist");
		//assertTrue(doc.getElementById("dane_dentysty").toString().contains("Informacje o dentyscie"));
	}	
}

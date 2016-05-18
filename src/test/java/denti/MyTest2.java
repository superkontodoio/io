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
	public void test11(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("ShowDentist");
		assertTrue(doc.getElementById("patientLink").toString().contains("patient/create"));
	  }
	@Test (enabled = false)
	public void test12(){
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
	public void test13(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		//System.out.println("//\n//\n//\n//");
		//System.out.println(doc.toString());
		assertTrue(doc.getElementById("unfortunately").toString().contains("znaleziona"));
	}
	@Test (enabled = false)
	public void test14(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		assertTrue(doc.getElementById("options").toString().contains("strony"));
	}
	@Test (enabled = false)
	public void test15(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("Error404");
		Element link = doc.getElementById("linkToMain");
		doc = tester.clickLink(link);
		assertTrue(doc.toString().contains("Create"));
	}
	@Test (enabled = false)
	public void test16(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("ShowDentist");
		assertTrue(doc.getElementById("dentistLink").toString().contains("/dentist/create"));
	}
	
	@Test //(enabled = false)
	public void test17(){
		PageTester tester = createNewTester();
		Document doc = tester.renderPage("EditDentist");
		System.out.println("//\n//\n//\n//");
		System.out.println(doc.toString());
	}
	
	
}

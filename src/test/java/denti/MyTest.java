package denti;

import static org.testng.AssertJUnit.assertTrue;
import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.test.PageTester;
import org.testng.annotations.Test;

public class MyTest {
	  public PageTester createNewTester() {
	      String appPackage = "com.project";
	      String appName = "";
	      return new PageTester(appPackage, appName, "src/main/webapp");
	  }
	  
	  @Test//(dataProvider = "dp")
	  public void test1() {
		  PageTester tester = createNewTester();
		  Document doc = tester.renderPage("Index");
		  assertTrue(doc.getElementById("dentistLink").toString().contains("Create Dentist Account"));
	  }

}

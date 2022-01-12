package basicjava;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGOrderOfAnnotationsTest {
//  @Test
  public void f() {
	  System.out.println("Simple test method");
	  //live connections.. dbs 
  }
 
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite");
  }
  
  @Test(groups =  {"smoke"})
  public void f1() {
	  System.out.println("smoke group test method");
	  //live connections.. dbs 
  }
  
  @BeforeGroups(groups = {"smoke"})
  public void beforeGroup() {
	  System.out.println("before group");
  }
  
  @AfterGroups(groups = {"smoke"})
  public void afterGroup() {
	  System.out.println("after group");
  }
  

}

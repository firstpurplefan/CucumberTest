package Annotation;

import static org.junit.Assert.assertTrue;

import org.junit.runner.JUnitCore;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

public class Annotation {
	public static WebDriver driver;
	private static boolean acceptNextAlert;

	// ----Given----
	@Given("^I am on login page$")
	public static void goToFacebook() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/SpringHibernateExample/login");
	}

	@Given("^Login as admin$")
	public static void loginAsAdmin() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("root123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	@Given("^I am on list page$")
	public static void goToList() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/SpringHibernateExample/login");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("root123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		wait.until(ExpectedConditions.urlToBe("http://localhost:8080/SpringHibernateExample/list"));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add New Employee")));
	}

	@Given("^I am on welcome page$")
	public static void goToWelcome() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/SpringHibernateExample/");
	}

	// ----Login Test----
	@When("^I enter username as \"(.*)\"$")
	public static void enterUsername(String arg1) {
		driver.findElement(By.id("username")).sendKeys(arg1);
	}

	@When("^I enter password as \"(.*)\"$")
	public static void enterPassword(String arg1) {
		driver.findElement(By.id("password")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	@Then("^Login should fail$")
	public static void checkFail() {
		if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/SpringHibernateExample/login?error")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	@Then("^Login should succeed$")
	public static void checkSucceed() {
		if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/SpringHibernateExample/list")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	@Then("^Relogin option should be available$")
	public static void checkRelogin() {
		if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/SpringHibernateExample/login?error")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	// ----Delete Test----
	@When("^I open employee page as \"(.*)\"$")
	public static void openEmployee(String arg1) {
		driver.findElement(By.linkText(arg1)).click();
	}

	@When("^I click on delete button$")
	public static void clickDeleteButton() {
		driver.findElement(By.name("button2")).click();
	}

	@When("^I confirm the delete$")
	public static void confirmDelete() {
		acceptNextAlert = true;
		assertTrue(closeAlertAndGetItsText().matches("^Do you want to delete this record[\\s\\S]$"));
	}

	@When("^I cancel the delete$")
	public static void cancelDelete() {
		acceptNextAlert = false;
		assertTrue(closeAlertAndGetItsText().matches("^Do you want to delete this record[\\s\\S]$"));
	}

	@Then("^Delete should fail$")
	public static void checkDeleteFail() {
		if (driver.getCurrentUrl().contains("http://localhost:8080/SpringHibernateExample/getEmployee/")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	@Then("^Delete should succeed$")
	public static void checkDeleteSuccess() {
		if (driver.getCurrentUrl().equals("http://localhost:8080/SpringHibernateExample/list")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	private static String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	// ----Add Test----
	@When("^I click on add employee$")
	public static void clickAdd() {
		driver.findElement(By.linkText("Add New Employee")).click();
	}

	@When("^I enter employee name as \"(.*)\"$")
	public static void enterName(String arg1) {
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(arg1);
	}

	@When("^I enter date as \"(.*)\"$")
	public static void enterDate(String arg1) {
		driver.findElement(By.id("datepicker")).clear();
		driver.findElement(By.id("datepicker")).sendKeys(arg1);
	}

	@When("^I enter employee salary as \"(.*)\"$")
	public static void enterSalary(String arg1) {
		driver.findElement(By.id("salary")).clear();
		driver.findElement(By.id("salary")).sendKeys(arg1);
	}

	@When("^I enter employee ssn as \"(.*)\"$")
	public static void enterSSn(String arg1) {
		driver.findElement(By.id("ssn")).clear();
		driver.findElement(By.id("ssn")).sendKeys(arg1);
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}

	@Then("^Registration should fail$")
	public static void checkNewFail() {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath("//span[@class='error']"));
		} catch (NoSuchElementException e) {
			element = null;
		}
		if (element != null) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	@Then("^Registration should succeed$")
	public static void checkNewSuccess() {
		if (driver.getTitle().equals("Registration Confirmation Page")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	@Then("^I shoule be on addnew page$")
	public static void checkOnNewPage() {
		if (driver.getCurrentUrl().equals("http://localhost:8080/SpringHibernateExample/new")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	// ----Update Test----
	@When("^I click on edit employee$")
	public static void clickEdit() {
		driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
	}

	@Then("^Edit should fail$")
	public static void checkEditFail() {
		WebElement element = null;
		try {
			element = driver.findElement(By.className("error"));
		} catch (NoSuchElementException e) {
			element = null;
		}
		if (element != null) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	@Then("^Edit should succeed$")
	public static void checkEditSuccess() {
		if (driver.getTitle().equals("Registration Confirmation Page")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	// ----Logout Test----
	@When("^I click on logout$")
	public static void clickLogout(String arg1) {
		driver.findElement(By.linkText("Logout")).click();
	}

	@Then("^Logout should succeed$")
	public static void checkLogoutSucceed() {
		if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/SpringHibernateExample/login?logout")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	@Then("^Logout relogin option should be available$")
	public static void checkLogoutRelogin() {
		if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/SpringHibernateExample/login?logout")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}

	// ----Welcome Page Test

	@When("^I click on login link$")
	public static void goToLogin() {
		driver.findElement(By.linkText("Login")).click();
	}

	@Then("^I shoule be on login page$")
	public static void checkOnPage() {
		if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/SpringHibernateExample/login")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			Assert.fail();
		}
		driver.close();
	}
}
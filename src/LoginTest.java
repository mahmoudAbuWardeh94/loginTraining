import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public WebDriver driver;

	SoftAssert softassert = new SoftAssert();

	@BeforeTest
	public void this_is_before_test() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://ereg.ets.org/ereg/public/jump?_p=GRI");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"notification-block\"]/button")).click();

	}

	@Test(priority = 1)
	public void invalid_userName_invalid_Password() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("gmail");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[3]")).click();

		String expectedValidationMsg = driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[1]/div/div[2]/p"))
				.getText();
		String actualValidationMsg = "Invalid Username and/or Password. Please try again.";

		softassert.assertEquals(actualValidationMsg, expectedValidationMsg);
		softassert.assertAll();

		driver.navigate().refresh();
		Thread.sleep(3000);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"notification-block\"]/button")).click();

	}

	@Test(priority = 2)
	public void invalid_userName_validPassword() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("mahmah88");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("Mm9941010465");
		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[3]")).click();
		String expectedValidationMsg = driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[1]/div/div[2]/p"))
				.getText();
		String actualValidationMsg = "Invalid Username and/or Password. Please try again.";

		softassert.assertEquals(actualValidationMsg, expectedValidationMsg);
		softassert.assertAll();

		driver.navigate().refresh();
		Thread.sleep(3000);
		Thread.sleep(2000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"notification-block\"]/button")).click();

	}

	@Test(priority = 3)

	public void valid_userName_invalidPassword() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);

		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("mahmoudAbuWardeh");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("0000");
		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[3]")).click();
		String expectedValidationMsg = driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[1]/div/div[2]/p"))
				.getText();
		String actualValidationMsg = "Invalid Username and/or Password. Please try again.";

		softassert.assertEquals(actualValidationMsg, expectedValidationMsg);
		softassert.assertAll();

		driver.navigate().refresh();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"notification-block\"]/button")).click();

	}

	@Test(priority = 4)

	public void empty_userName() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("0000");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[3]")).click();

		String expectedValidationMsg = driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[1]/div[1]")).getText();

		String actualValidationMsg = "Username is required";

		softassert.assertEquals(actualValidationMsg, expectedValidationMsg);
		softassert.assertAll();
		Thread.sleep(3000);

		driver.navigate().refresh();

		driver.findElement(By.xpath("//*[@id=\"notification-block\"]/button")).click();

	}

	@Test(priority = 5)

	public void empty_password() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("mahmoud");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[3]")).click();

		String expectedValidationMsg = driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[2]/div[1]")).getText();

		String actualValidationMsg = "Password is required";

		softassert.assertEquals(actualValidationMsg, expectedValidationMsg);
		softassert.assertAll();

		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"notification-block\"]/button")).click();

	}

	@Test(priority = 6)

	public void empty_userName_emptyPassword() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[3]")).click();

		String actualValUserName = driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[1]/div[1]")).getText();

		String actualValPassword = driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[2]/div[1]")).getText();

		String expectedValUserName = "Username is required";

		String expectedValPassword = "Password is required";

		softassert.assertEquals(actualValUserName, expectedValUserName);
		softassert.assertEquals(actualValPassword, expectedValPassword);

		softassert.assertAll();

		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"notification-block\"]/button")).click();

	}

	@Test(priority = 7)

	public void valid_username_validPassword() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("mahmoudAbuWardeh");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("Mm9941010465");
		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/div[3]")).click();

		Thread.sleep(5000);

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://ereg.ets.org/ereg/home?_p=GRI";

		softassert.assertEquals(actualUrl, expectedUrl);
		softassert.assertAll();
	}

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void userLoginTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("testng01@gmail.com");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("pFA!?97zxV");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log in']")));
        loginButton.click();

        WebElement logOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")));
        Assert.assertTrue(logOutButton.isDisplayed(), "Logout button is not displayed.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

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

public class VerifyHomePageLoadTest {

    public WebDriver driver;
    public String baseURL = "https://demowebshop.tricentis.com/";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void verifyHomePageLoadsCorrectly() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Page title verification
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Demo Web Shop", "Page title is not as expected!");

        // Header verification
        WebElement booksLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")));
        Assert.assertTrue(booksLink.isDisplayed(), "Books link is not displayed!");

        WebElement computerLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")));
        Assert.assertTrue(computerLink.isDisplayed(), "Computer link is not displayed!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

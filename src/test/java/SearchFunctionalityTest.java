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

public class SearchFunctionalityTest {

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
    public void searchForLaptop() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
        searchBox.sendKeys("laptop");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")));
        searchButton.click();

        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[1]/a/img")));
        String productText = productElement.getAttribute("alt").toLowerCase();

        Assert.assertTrue(productText.contains("laptop"), "The product element does not have 'laptop' in its description. Actual description: " + productText);

        productElement.click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SortingAndFilterTest {
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
    public void verifyProductFilterAndSorting() {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement apparelCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]/a")));
        apparelCategory.click();

        WebElement sortDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"products-orderby\"]")));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByVisibleText("Price: Low to High");

        List<WebElement> productPrices = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("prices")));
        double previousPrice = 0;

        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().trim(); // Removes extra spaces

            try {
                double currentPrice = Double.parseDouble(priceText);

                // Print current price check
                System.out.println("Current product price: $" + currentPrice);

                Assert.assertTrue(currentPrice >= previousPrice,
                        "Products are not sorted by price in ascending order. Current price: " + currentPrice + " Previous price: " + previousPrice);
                previousPrice = currentPrice; // Update the previous price
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format: " + priceText);
            }
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

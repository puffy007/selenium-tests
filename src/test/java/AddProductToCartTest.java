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

public class AddProductToCartTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addProductToCartTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://demowebshop.tricentis.com/");
        WebElement computersCategory = driver.findElement(By.linkText("Computers"));
        computersCategory.click();

        WebElement notebookLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div/h2/a")));
        notebookLink.click();

        WebElement laptopLink = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div/div/div[1]/a/img"));
        laptopLink.click();

        WebElement quantityInput = driver.findElement(By.id("addtocart_31_EnteredQuantity"));
        quantityInput.clear();
        quantityInput.sendKeys("1");

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-31")));
        addToCartButton.click();

        WebElement shoppingCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")));
        shoppingCart.click();

        WebElement checkoutCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[5]/input")));
        String quantityInCart = checkoutCart.getAttribute("value");
        Assert.assertEquals(quantityInCart, "1", "The quantity of the product in the cart is not 1.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

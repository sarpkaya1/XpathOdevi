import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IlkXpathTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void clickButtonTest() {
        // DemoQA Elements sayfasına git
        driver.get("https://demoqa.com/elements");

        // "Buttons" seçeneğini tıklayın
        WebElement buttonsMenu = driver.findElement(By.xpath("//*[@id='item-4']"));
        buttonsMenu.click();

        // "Click Me" düğmesine çift tıklayın
        Actions actions = new Actions(driver);
        WebElement clickMeButton = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
        actions.doubleClick(clickMeButton).perform();

        // Görünen mesajın doğru olduğunu kontrol edin
        WebElement message = driver.findElement(By.xpath("//*[@id='doubleClickMessage']"));
        Assert.assertEquals(message.getText(), "You have done a double click", "Mesaj yanlış.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
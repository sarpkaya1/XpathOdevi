import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IkinciXpathTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addRecordTest() {
        // Web Tables sayfasına git
        driver.get("https://demoqa.com/webtables");

        // "ADD" düğmesini tıklayın
        WebElement addButton = driver.findElement(By.xpath("//*[@id='addNewRecordButton']"));
        addButton.click();

        // Formu doldurun
        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("John");
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Doe");
        driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("john.doe@example.com");
        driver.findElement(By.xpath("//*[@id='age']")).sendKeys("30");
        driver.findElement(By.xpath("//*[@id='salary']")).sendKeys("50000");
        driver.findElement(By.xpath("//*[@id='department']")).sendKeys("HR");

        // "Submit" düğmesini tıklayın
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        // Eklenen kaydı düzenleyin (örneğin 4. satırdaki kaydı düzenleyelim)
        WebElement editButton = driver.findElement(By.xpath("//*[@id='edit-record-4']"));
        editButton.click();

        // Yaşı değiştirin ve tekrar submit edin
        WebElement ageField = driver.findElement(By.xpath("//*[@id='age']"));
        ageField.clear();
        ageField.sendKeys("35");
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        // Kaydın değiştiğini kontrol edin
        WebElement ageValue = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[text()='35']"));
        Assert.assertTrue(ageValue.isDisplayed(), "Kayıt güncellenmedi.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

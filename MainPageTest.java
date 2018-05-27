import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private SearchVideoPage searchVideoPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/video/");
        searchVideoPage = PageFactory.initElements(driver, SearchVideoPage.class);
    }

    @Test
    public void test() throws InterruptedException {
        VideoPage videoPage = searchVideoPage.searchContext("Ураган");
        videoPage.searchAnyTrailerByNumber(2);

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'thumb-image_hovered')]")).isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

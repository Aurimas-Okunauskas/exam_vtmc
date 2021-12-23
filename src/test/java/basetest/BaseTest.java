package basetest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    protected void getPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
    }

    @AfterMethod
    protected void closeBrowser() {
        driver.close();
    }

    @AfterSuite
    protected void tearDown() {
        driver.quit();
    }

}

package ovh.enyo.hlm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
                "--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://127.0.0.1:8080/books");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addBookAndUpdateAndPagingTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.wait(20);
        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/p/a[1]/i"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
        el = driver.findElement(By.xpath("//*[@id=\"nameId\"]"));
        el.sendKeys("TestBookName");
        el = driver.findElement(By.xpath("//*[@id=\"authorsId\"]"));
        el.sendKeys("TestBookAuthor");
        el = driver.findElement(By.xpath("//*[@id=\"isbnId\"]"));
        el.sendKeys("1234567");
        el = driver.findElement(By.xpath("//*[@id=\"formatId\"]"));
        el.sendKeys("TestBookFormat");
        el = driver.findElement(By.xpath("//*[@id=\"genresId\"]"));
        el.sendKeys("TestBookGenre");
        el = driver.findElement(By.xpath("//*[@id=\"publisherId\"]"));
        el.sendKeys("TestBookPublisher");
        el = driver.findElement(By.xpath("//*[@id=\"qualityId\"]"));
        el.sendKeys("TestBookQuality");
        el = driver.findElement(By.xpath("//*[@id=\"pagesId\"]"));
        el.clear();
        el.sendKeys("2137");
        el = driver.findElement(By.xpath("//*[@id=\"priceId\"]"));
        el.clear();
        el.sendKeys("14.88");
        el = driver.findElement(By.xpath("//*[@id=\"readId\"]"));
        el.click();
        el = driver.findElement(By.xpath("//*[@id=\"hardcoverId\"]"));
        el.click();
        el = driver.findElement(By.xpath("//*[@id=\"boughtId\"]"));
        el.click();
        el = driver.findElement(By.xpath("/html/body/div[1]/form/button"));
        el.click();
        el = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/span[2]/a"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.click();
        el = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[2]/td[8]/a[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//*[@id=\"nameId\"]"));
        el.clear();
        el.sendKeys("UpdateTestBookName");
        el = driver.findElement(By.xpath("/html/body/div[1]/form/button"));
        el.click();
        el = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/span[2]/a"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.click();
        el = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[2]/td[8]/a[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        String testBookName = "UpdateTestBookName";
        String name = driver.findElement(By.xpath("//*[@id=\"nameId\"]")).getAttribute("value");
        String testBookAuthors = "TestBookAuthor";
        String authors = driver.findElement(By.name("authors")).getAttribute("value");
        String testBookIsbn = "1234567";
        String isbn = driver.findElement(By.name("isbn")).getAttribute("value");
        String testBookFormat = "TestBookFormat";
        String format = driver.findElement(By.name("format")).getAttribute("value");
        String testBookGenres = "TestBookGenre";
        String genres = driver.findElement(By.name("genres")).getAttribute("value");
        String testBookPublisher = "TestBookPublisher";
        String publisher = driver.findElement(By.name("publisher")).getAttribute("value");
        String testBookQuality = "TestBookQuality";
        String quality = driver.findElement(By.name("quality")).getAttribute("value");
        String testBookPrice = "14.88";
        String price = driver.findElement(By.name("price")).getAttribute("value");
        String testBookPages = "2137";
        String pages = driver.findElement(By.name("pages")).getAttribute("value");

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(testBookName).isEqualTo(name);
        softly.assertThat(testBookAuthors).isEqualTo(authors);
        softly.assertThat(testBookIsbn).isEqualTo(isbn);
        softly.assertThat(testBookFormat).isEqualTo(format);
        softly.assertThat(testBookGenres).isEqualTo(genres);
        softly.assertThat(testBookPublisher).isEqualTo(publisher);
        softly.assertThat(testBookQuality).isEqualTo(quality);
        softly.assertThat(testBookPages).isEqualTo(pages);
        softly.assertThat(testBookPrice).isEqualTo(price);

       softly.assertAll();
    }

//    @Test
//    public void deleteAndFilterAndPageNumberBookTest() {
//
//        String preTotalItemsTemp = "Total Items: 8";
//        String preTotalItems = driver.findElement(By.xpath("/html/body/div[1]/div[4]")).getText();
//        WebElement el = driver.findElement(By.xpath("//*[@id=\"keyword\"]"));
//        el.sendKeys("Test");
//        el.sendKeys(Keys.ENTER);
//
//        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr/td[8]/a[3]")).click();
//        String postTotalItems = driver.findElement(By.xpath("/html/body/div[1]/div[4]")).getText();
//        String postTotalItemsTemp =  "Total Items: 7";
//
//        System.out.println(preTotalItems);
//        System.out.println(postTotalItems);
//
//        SoftAssertions softly = new SoftAssertions();
//        softly.assertThat(preTotalItems).isEqualTo(preTotalItemsTemp);
//        softly.assertThat(postTotalItems).isEqualTo(postTotalItemsTemp);
//        softly.assertAll();
//    }
//
//    @Test
//    public void testDetailsBook() {
//        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td[8]/a[1]"));
//        el.click();
//        String testName = driver.findElement(By.name("name")).getAttribute("value");
//        String name = "De Doctrina Christiana";
//        String testGenre = driver.findElement(By.name("genres")).getAttribute("value");
//        String genre = "theology";
//        String testPages = driver.findElement(By.name("pages")).getAttribute("value");
//        String pages = "342";
//
//        SoftAssertions softly = new SoftAssertions();
//
//        softly.assertThat(testName).isEqualTo(name);
//        softly.assertThat(testGenre).isEqualTo(genre);
//        softly.assertThat(testPages).isEqualTo(pages);
//
//        softly.assertAll();
//    }



}

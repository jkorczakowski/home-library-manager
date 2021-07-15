package ovh.enyo.hlm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8080/notes");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addNoteAndDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/p/a[1]/i"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
        driver.findElement(By.xpath("//*[@id=\"titleId\"]")).sendKeys("Test Title");
        driver.findElement(By.xpath("//*[@id=\"contentId\"]")).sendKeys("Test Content");
        el = driver.findElement(By.xpath("//*[@id=\"bookId\"]"));
        Select dropDown = new Select(el);
        dropDown.selectByIndex(1);
        driver.findElement(By.xpath("/html/body/div[1]/form/button")).click();
        el = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td[3]/a[1]"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.click();

        String testTitle = driver.findElement(By.name("title")).getAttribute("value");
        String title = "Test Title";
        String testContent = driver.findElement(By.name("content")).getAttribute("value");
        String content = "Test Content";

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(testTitle).isEqualTo(title);
        softly.assertThat(testContent).isEqualTo(content);
        softly.assertAll();
    }

    @Test
    public void deleteAndTotalItemsNote() {
        String preTotalItemsTemp = "Total Items: 4";
        String preTotalItems = driver.findElement(By.xpath("/html/body/div[1]/div[4]")).getText();
        WebElement el = driver.findElement(By.xpath("//*[@id=\"keyword\"]"));
        el.sendKeys("Test");
        el.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr/td[3]/a[3]")).click();
        String postTotalItems = driver.findElement(By.xpath("/html/body/div[1]/div[4]")).getText();
        String postTotalItemsTemp =  "Total Items: 3";

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(preTotalItems).isEqualTo(preTotalItemsTemp);
        softly.assertThat(postTotalItems).isEqualTo(postTotalItemsTemp);
        softly.assertAll();
    }

    @Test
    public void editNote() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[3]/a[2]"));
        el.click();
        el = driver.findElement(By.xpath("//*[@id=\"titleId\"]"));
        el.clear();
        el.sendKeys("Przypomnieć Michałowi żeby oddał ją w końcu!");
        driver.findElement(By.xpath("/html/body/div[1]/form/button")).click();
        el = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[1]"));
        wait.until(ExpectedConditions.visibilityOf(el));
        String title = el.getText();
        String testTitle = "Przypomnieć Michałowi żeby oddał ją w końcu!";

        assertThat(title).isEqualTo(testTitle);

    }

}

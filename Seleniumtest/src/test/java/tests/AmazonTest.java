package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

    private WebDriver driver;

    public AmazonTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
    }

    public void visitPage(String page) {
        driver.get(page);
    }

    public Select getDropdown(String dropdownId) {
        Select dropdown = new Select (driver.findElement(By.id(dropdownId)));
        return dropdown;
    }

    public void selectVisibleElement(Select dropdown, String element){
        dropdown.selectByVisibleText(element);
    }

    public void writeTextOnElement(String element, String text) {
        driver.findElement(By.id(element)).sendKeys(text);
    }

    public void clickAtElement(String elementXPath) {
        driver.findElement(By.xpath(elementXPath)).click();
    }

    public List<WebElement> selectAllBooks(String booksSpan) {
        return driver.findElements(By.xpath(booksSpan));
    }

    public String getText(WebElement element, String text) {
        return element.findElement(By.xpath(text)).getText();
    }

    public WebElement getBookObject(WebElement element, String address) {
        return element.findElement(By.xpath(".//*[@class='a-size-medium a-color-base a-text-normal']"));
    }

    public void clickOnBook(WebElement book) {
        book.click();
    }

    public String getBookTitle(String bookAddress) {
        return driver.findElement(By.xpath(bookAddress)).getAttribute("innerHTML");
    }

    public void closeDriver() {
        driver.quit();
    }

}

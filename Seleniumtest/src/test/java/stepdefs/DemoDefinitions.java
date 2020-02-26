package stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDefinitions {


    private WebDriver driver;
    private String bookname;
    private WebElement book = null;

    @Before
    public void setUp() throws Exception {
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

    @Given("^I navigate to “www\\.amazon\\.com”\\.$")
    public void NavegateToAmazon() throws Throwable {
        driver.get("https://www.amazon.com/");
    }

    @When("I select the option “Books” in the dropdown next to the search text input criteria.")
    public void OptionBooksInTheDropdown() throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
        dropdown.selectByVisibleText("Books");
    }

    @Then("I search for “Test automation”.")
    public void iSearchForTestAutomation() throws Throwable {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Test Automation");
        driver.findElement(By.xpath("//div/input[@value='Go']")).click();
    }

    @And("I select the cheapest book of the page without using any sorting method available.")
    public void iSelectTheCheapestBook() throws Throwable {
        List<WebElement> el = driver.findElements(By.xpath("//span[@cel_widget_id=\"SEARCH_RESULTS-SEARCH_RESULTS\"]"));

        double cheapestPrice = 50000000000000.0;

        for (WebElement e : el) {


            try {
                String priceWhole = e.findElement(By.xpath(".//*[@class='a-price-whole']")).getText();
                String priceFraction = e.findElement(By.xpath(".//*[@class='a-price-fraction']")).getText();
                String totalPrice = priceWhole + "." + priceFraction;
                Double price = Double.parseDouble(totalPrice);
                System.out.println(price);

                if (price < cheapestPrice) {
                    bookname = e.findElement(By.xpath(".//*[@class='a-size-medium a-color-base a-text-normal']")).getText();
                    book = e.findElement(By.xpath(".//*[@class='a-size-medium a-color-base a-text-normal']"));
                    cheapestPrice = price;
                }
            } catch (org.openqa.selenium.NoSuchElementException exception) {
                System.out.println("Got one element without price");
            }
        }

    }

    @When("I reach the detailed book page, I check if the name in the header is the same name of the book that I select previously.")
    public void DetailedBookPage() throws Throwable {
        book.click();
        String title = driver.findElement(By.xpath("//title")).getAttribute("innerHTML");
        title.replace("&nbsp;", " ");
        title.replace("&quot;", "\"");
        title.contains(bookname);
        driver.quit();
    }
}

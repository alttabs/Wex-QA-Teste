package stepdefs;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPage;



public class DemoDefinitions {
    private String bookname;
    private WebElement book = null;
    private AmazonPage pom;

    @Before
    public void setUp() throws Exception {
        pom = new AmazonPage();
    }

    @Given("^I navigate to “www\\.amazon\\.com”\\.$")
    public void NavegateToAmazon() throws Throwable {
        pom.navigateToAmazon("https://www.amazon.com/");
    }

    @When("I select the option “Books” in the dropdown next to the search text input criteria.")
    public void OptionBooksInTheDropdown() throws Throwable {
        Select dropDown = pom.getDropdown("searchDropdownBox");
        pom.selectElementFromDropdown(dropDown, "Books");
    }

    @Then("I search for “Test automation”.")
    public void iSearchForTestAutomation() throws Throwable {
        pom.fillSearchBar("twotabsearchtextbox", "Test Automation");
        pom.clickSearchBarConfirmation("//div/input[@value='Go']");
    }

    @And("I select the cheapest book of the page without using any sorting method available.")
    public void iSelectTheCheapestBook() throws Throwable {
        List<WebElement> elements = pom.selectResultingBooks();

        double cheapestPrice = 50000000000000.0;

        for (WebElement e : elements) {


            try {
                Double price = pom.getBookingPrice(e, ".//*[@class='a-price-whole']", ".//*[@class='a-price-fraction']");
                System.out.println(price);

                if (price < cheapestPrice) {
                    bookname = pom.getBookName(e);
                    book = pom.getBookObject(e);
                    cheapestPrice = price;
                }
            } catch (org.openqa.selenium.NoSuchElementException exception) {
                System.out.println("Got one element without price");
            }
        }
    }

    @When("I reach the detailed book page, I check if the name in the header is the same name of the book that I select previously.")
    public void DetailedBookPage() throws Throwable {
        pom.selectBook(book);
        String title = pom.getBookTitle();
        title.replace("&nbsp;", " ");
        title.replace("&quot;", "\"");
        title.contains(bookname);
        pom.closeBrowser();
    }

}

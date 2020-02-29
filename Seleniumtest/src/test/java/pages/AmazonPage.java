package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tests.AmazonTest;

public class AmazonPage {

    private AmazonTest test;

    public AmazonPage() {
        //Setup Driver
        test = new AmazonTest();
    }

    public void navigateToAmazon(String page) {
        test.visitPage(page);
    }

    public Select getDropdown(String dropdownId) {
        return test.getDropdown(dropdownId);
    }

    public void selectElementFromDropdown(Select dropdown, String element) {
        test.selectVisibleElement(dropdown, element);
    }


    public void fillSearchBar(String searchBarId, String contentToFill) {
        test.writeTextOnElement(searchBarId, contentToFill);
    }


    public void clickSearchBarConfirmation(String elementXPath) {
        test.clickAtElement(elementXPath);
    }

    public List<WebElement> selectResultingBooks() {
        return test.selectAllBooks("//span[@cel_widget_id=\"SEARCH_RESULTS-SEARCH_RESULTS\"]");
    }

    public Double getBookingPrice(WebElement element, String wholePriceIdAddress, String fractionPriceAddress) {
        String priceWhole = test.getText(element, wholePriceIdAddress);
        String priceFraction = test.getText(element, fractionPriceAddress);
        String totalPrice = priceWhole + "." + priceFraction;
        Double price = Double.parseDouble(totalPrice);
        return price;
    }

    public String getBookName(WebElement element) {
        return test.getText(element, ".//*[@class='a-size-medium a-color-base a-text-normal']");
    }

    public WebElement getBookObject(WebElement element) {
        return test.getBookObject(element, ".//*[@class='a-size-medium a-color-base a-text-normal']");
    }

    public void selectBook(WebElement book) {
        test.clickOnBook(book);
    }

    public String getBookTitle() {
        return test.getBookTitle("//title");
    }

    public void closeBrowser() {
        test.closeDriver();
    }

}

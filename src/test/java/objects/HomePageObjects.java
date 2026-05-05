package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
    @FindBy(xpath = "//input[contains(@placeholder,'Name')]")
    public static WebElement nameInput;

    @FindBy(xpath = "(//input[contains(@placeholder,'Email')])[2]")
    public static WebElement emailInput;

    @FindBy(xpath = "//input[@id='name']")
    public static WebElement nameInput2;

    @FindBy(xpath = "//input[@id='email']")
    public static WebElement emailInput2;

    @FindBy(xpath = "//input[@id='password']")
    public static WebElement passwordInput;

    @FindBy(xpath = "//select[@id='days']")
    public static WebElement daysInput;

    @FindBy(xpath = "//select[@id='months']")
    public static WebElement monthsInput;

    @FindBy(xpath = "//select[@id='years']")
    public static WebElement yearsInput;

    @FindBy(xpath = "//input[@id='first_name']")
    public static WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last_name']")
    public static WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='company']")
    public static WebElement companyInput;

    @FindBy(xpath = "//input[@id='address1']")
    public static WebElement addressInput;

    @FindBy(xpath = "//input[@id='address2']")
    public static WebElement address2Input;

    @FindBy(xpath = "//select[@id='country']")
    public static WebElement countryInput;

    @FindBy(xpath = "//input[@id='state']")
    public static WebElement stateInput;

    @FindBy(xpath = "//input[@id='city']")
    public static WebElement cityInput;

    @FindBy(xpath = "//input[@id='zipcode']")
    public static WebElement zipcodeInput;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public static WebElement mobileNumberInput;
}

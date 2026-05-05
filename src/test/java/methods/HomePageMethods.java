package methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.HomePageObjects;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static methods.DriverManager.driver;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageMethods {
    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // HEADLESS MODE
        options.addArguments("--headless=new");

        // STABILITY OPTIONS FOR JENKINS
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // BROWSER SETTINGS
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        PageFactory.initElements(driver, HomePageObjects.class); // Initialize HomePageObjects
    }

    public static void openUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void enterNameAndEmail(String name, String email) throws InterruptedException {
//        Thread.sleep(3000);
        HomePageObjects.nameInput.sendKeys(name);
        String randomtext = RandomStringUtils.random(5, true, true);
        HomePageObjects.emailInput.sendKeys(email+randomtext+"@example.com");
    }

    public static void enterUserDetails(String title, String name, String password, String dob) throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='" + title + "']")).click();
        HomePageObjects.nameInput2.sendKeys(name);
        HomePageObjects.passwordInput.sendKeys(password);
        String[] dobParts = dob.split("-");
        String days = dobParts[0];
        String month = dobParts[1];
        String year = dobParts[2];
        HomePageObjects.daysInput.sendKeys(days);
        HomePageObjects.monthsInput.sendKeys(month);
        HomePageObjects.yearsInput.sendKeys(year);
    }

    public static void selectCheckbox(String checkboxName) {
        driver.findElement(By.xpath("//*[contains(text(),'" + checkboxName + "')]/..//input")).click();
    }

    public static void enterAddressInfo(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        HomePageObjects.firstNameInput.sendKeys(firstName);
        HomePageObjects.lastNameInput.sendKeys(lastName);
        HomePageObjects.companyInput.sendKeys(company);
        HomePageObjects.addressInput.sendKeys(address);
        HomePageObjects.address2Input.sendKeys(address2);
        HomePageObjects.countryInput.sendKeys(country);
        HomePageObjects.stateInput.sendKeys(state);
        HomePageObjects.cityInput.sendKeys(city);
        HomePageObjects.zipcodeInput.sendKeys(zipcode);
        HomePageObjects.mobileNumberInput.sendKeys(mobileNumber);
    }
}

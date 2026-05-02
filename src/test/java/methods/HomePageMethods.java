package methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static methods.DriverManager.driver;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageMethods {
    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public static void openUrl(String url) {
    driver.get(url);
    driver.manage().window().maximize();
    }

    public static void enterNameAndEmail(String name, String email) {
        objects.HomePageObjects.nameInput.sendKeys(name);
        objects.HomePageObjects.emailInput.sendKeys(email);
    }

    public static void enterUserDetails(String title, String name, String email, String password, String dob) {
        driver.findElement(By.xpath("//input[@value='"+title+"']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(title);
        objects.HomePageObjects.emailInput.sendKeys(email);

    }
}

package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
    @FindBy(xpath = "//input[contains(@placeholder,'Name')]")
    public static WebElement nameInput;

    @FindBy(xpath = "//input[contains(@placeholder,'Email')]")
    public static WebElement emailInput;


}

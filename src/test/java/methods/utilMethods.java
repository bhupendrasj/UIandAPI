package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

import static methods.DriverManager.driver;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class utilMethods {

    public static void waitUntilButtonNotClickable(WebElement button) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(button)));
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitUntilPresenceOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitUntilTextToBePresentInElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUntilTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitUntilAlertIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitUntilElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void verifyPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    public static void clickOnTheButton(String buttonName) {
        waitUntilElementToBeClickable(driver.findElement(By.xpath("//*[text()='" + buttonName + "']")));
        driver.findElement(By.xpath("//*[text()='" + buttonName + "']")).click();
    }

    public static void verifyTextOnPage(String text) {
        By textLocator = By.xpath("//*[contains(normalize-space(.),'" + text + "')]");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator)).isDisplayed());
        } catch (TimeoutException e) {
            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-SSS"));
            Path screenshotPath = Paths.get("target", "ui-verification-failure-" + timestamp + ".png");
            Path pageSourcePath = Paths.get("target", "ui-verification-failure-" + timestamp + ".html");
            StringBuilder evidence = new StringBuilder();

            try {
                Files.createDirectories(screenshotPath.getParent());
                Files.write(screenshotPath, ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                evidence.append(" Screenshot: ").append(screenshotPath.toAbsolutePath()).append(".");
            } catch (Exception captureError) {
                evidence.append(" Screenshot capture failed: ").append(captureError.getMessage()).append(".");
            }

            try {
                Files.write(
                        pageSourcePath,
                        driver.getPageSource().getBytes(StandardCharsets.UTF_8)
                );
                evidence.append(" Page source: ").append(pageSourcePath.toAbsolutePath()).append(".");
            } catch (Exception captureError) {
                evidence.append(" Page source capture failed: ").append(captureError.getMessage()).append(".");
            }

            String currentUrl = "unavailable";
            String currentTitle = "unavailable";
            String currentBodyText = "unavailable";
            try {
                currentUrl = driver.getCurrentUrl();
                currentTitle = driver.getTitle();
                currentBodyText = driver.findElement(By.tagName("body")).getText();
            } catch (Exception captureError) {
                evidence.append(" Page text capture failed: ").append(captureError.getMessage()).append(".");
            }

            throw new AssertionError(
                    "Timed out after 10 seconds waiting for expected visible text '" + text
                            + "'. Current URL: " + currentUrl
                            + "; title: " + currentTitle
                            + "; body text: " + currentBodyText + "."
                            + evidence,
                    e);
        }
    }

    public static void dismissBlockingAdvertisement() {
        if (driver == null) {
            return;
        }

        try {
            WebElement adFrame = driver.findElements(By.id("aswift_2")).stream()
                    .findFirst()
                    .orElse(null);
            if (adFrame == null) {
                return;
            }

            driver.switchTo().frame(adFrame);
            WebElement closeButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(By.id("dismiss-button")));
            closeButton.click();
        } catch (NoSuchFrameException | TimeoutException ignored) {
            // The ad may disappear before its frame or Close control becomes available.
        } catch (WebDriverException ignored) {
            // Ads are third-party content and can disappear or change while the page loads.
        } finally {
            try {
                driver.switchTo().defaultContent();
            } catch (WebDriverException ignored) {
                // The browser may already have closed; preserve the scenario's own outcome.
            }
        }
    }
}

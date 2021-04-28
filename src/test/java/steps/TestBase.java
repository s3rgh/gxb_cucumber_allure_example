package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import pages.GooglePage;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver webDriver;
    GooglePage googlePage;

    public void initialize() {

        if (webDriver != null) {
            return;
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> webDriver.quit())
        );
    }

    void tearDown() {
        // webDriver.quit();
    }
}

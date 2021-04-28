package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    public void open(String arg0) {
        driver.get(arg0);
    }

    public void isOpened() {
        WebElement webElement = driver.findElement(By.xpath("//img[@alt='Google']"));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        assertThat(webElement.isEnabled()).isEqualTo(true);
    }

    public void navigateToSearchLine() {
        Actions builder = new Actions(driver);
        WebElement webElement = driver.findElement(By.name("q"));
        builder.moveToElement(webElement).build().perform();
    }

    public void enterText(String arg0) {
        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys(arg0);
        webElement.submit();
    }

    public void checkTaskSuccess() {
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='g']"));
        assertThat(webElements.size() >= 10).isEqualTo(true);
        WebElement check = driver.findElement(By.xpath("//div[@class='g']/descendant::cite[contains(text(), 'https://www.mvideo.ru')]"));
        assertThat(check.isDisplayed()).isEqualTo(true);
    }
}

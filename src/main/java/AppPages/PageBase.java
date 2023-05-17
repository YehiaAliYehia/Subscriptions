package AppPages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class PageBase {
    public WebDriver driver;
    SoftAssert Validate = new SoftAssert();
    public void waitUntil(WebDriver driver, By element) {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void selectFromDropdown(WebDriver driver , By Element , String Text){
        Select dropdown = new Select(driver.findElement(Element));
        dropdown.selectByVisibleText(Text);

    }

    public void selectFromDropdownSpan(WebDriver driver , By Element , String TagName , int Index){

        WebElement dropdownBtn = driver.findElement(Element) ;
        dropdownBtn.click();
        List<WebElement> dropdownItems = dropdownBtn.findElements(By.name(TagName));
        dropdownItems.get(Index).click();

    }
}

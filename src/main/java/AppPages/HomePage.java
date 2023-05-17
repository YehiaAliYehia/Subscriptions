package AppPages;

import TestData.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageBase {


    private By Logo = By.id("jawwy-logo-web");
    private By Country_Selector = By.className("country-current");
    private By CurrencyTxt = By.xpath("/div[@class='Price']/i[@xpath='1']");
    private By Plan_Section = By.className("plan-section");
    private By Plan_Type = By.className("plan-title");
    private WebDriver i;


    public void Select_Country(WebDriver driver, Country_ID country) throws InterruptedException {
        driver.findElement(Country_Selector).click();
        driver.findElement(By.id(country.toString())).click();
        Validate.assertEquals(driver.findElement(Plan_Section).isDisplayed(), true);

    }

    public void validte_Plans_Section_Isdisplayed(WebDriver driver) {
        Validate.assertEquals(driver.findElement(Plan_Section).isDisplayed(), true);

    }

    public String get_Subscription_plan_Text(WebDriver driver, int num) {
        return driver.findElements(Plan_Type).get(num).getText();


    }


    public String Get_Prices_Saudi(WebDriver driver, int num, Saudi_Prices ss) {
        return driver.findElement(By.xpath("(//b[normalize-space()='" + ss + "'])[" + num + "]")).getText();


    }

    public String Get_Prices_Kuwait(WebDriver driver, int num, Kuwait_Prices ss) {
        return driver.findElement(By.xpath("//b[normalize-space()='" + ss + "']")).getText();
    }


    public String Get_Prices_Bahrain(WebDriver driver, int num, Bahrain_Prices ss) {
        return driver.findElement(By.xpath("//b[normalize-space()='" + ss + "']")).getText();
    }


    public String Get_Currency(WebDriver driver, Currencies currency) {

        WebElement t = driver.findElement(By.xpath("//div[@class='price']"));
        //identify child nodes with ./child::* expression in xpath
        List<WebElement> c = t.findElements(By.xpath("./child::*"));
        // iterate child nodes
        String x = null;
        for (WebElement i : c) {
            //getText() to get text for child nodes
            System.out.println(i.getText());

            i.findElement(By.xpath("//i[contains(@text,'month')]")).getText();

        }
        return             i.findElement(By.xpath("[contains(text() , 'month']")).getText();


    }
}

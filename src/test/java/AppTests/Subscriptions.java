package AppTests;

import AppSteps.Subscribtion_Steps;
import TestBases.TestBase;
import org.testng.annotations.Test;

public class Subscriptions extends TestBase {


    private  Subscribtion_Steps subscribtion_Steps = new Subscribtion_Steps();


    @Test(priority = 0)
    public void validate_Subscriptions_Types_For_Saudi_arabia() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Saudi_country(driver);
        subscribtion_Steps.saudi_Subscriptions_Should_have_types(driver);
    }

    @Test(priority = 1)
    public void validate_Subscriptions_Types_For_Kuwait() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Kuwait_country(driver);
        subscribtion_Steps.saudi_Subscriptions_Should_have_types(driver);
    }


    @Test(priority = 2)
    public void validate_Subscriptions_Types_For_Bahrain() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Bahrain_country(driver);
        subscribtion_Steps.saudi_Subscriptions_Should_have_types(driver);
    }

    @Test(priority = 3)
    public void validate_Subscriptions_Prices_For_Saudi() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Saudi_country(driver);
        subscribtion_Steps.every_Subscription_Should_have_price_Saudi(driver);
    }

    @Test(priority = 4)
    public void validate_Subscriptions_Prices_For_Kuwait() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Kuwait_country(driver);
        subscribtion_Steps.every_Subscription_Should_have_price_Kuwait(driver);
    }

    @Test(priority = 5)
    public void validate_Subscriptions_Prices_For_Bahrain() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Bahrain_country(driver);
        subscribtion_Steps.every_Subscription_Should_have_price_Bahrain(driver);
    }


    @Test(priority = 6)
    public void validate_Subscriptions_Currency_For_Saudi() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Saudi_country(driver);
        subscribtion_Steps.currency_Should_be_SAR(driver);
    }

    @Test(priority = 7)
    public void validate_Subscriptions_Currency_For_Kuwait() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Kuwait_country(driver);
        subscribtion_Steps.currency_Should_be_KW(driver);
    }

    @Test(priority = 7)
    public void validate_Subscriptions_Currency_For_Bahrain() throws InterruptedException {
        subscribtion_Steps.the_user_selects_the_Bahrain_country(driver);
        subscribtion_Steps.currency_Should_be_BH(driver);
    }


}

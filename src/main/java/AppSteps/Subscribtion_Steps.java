package AppSteps;

import AppPages.HomePage;
import TestData.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Subscribtion_Steps  {


    static String scrShotDir = "bugsrecorder/screenshots";
    File scrFile;
    static File scrShotDirPath = new java.io.File("./" + scrShotDir + "//");
    String destFile;



     WebDriver driver;
    HomePage homePage = new HomePage();
    SoftAssert Validate = new SoftAssert();

    public Subscribtion_Steps() {

    }


    @Given("^Navigate to the link$")
    public void navigate_to_the_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the user selects the Saudi country$")
    public void the_user_selects_the_Saudi_country(WebDriver driver) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
homePage.Select_Country(driver , Country_ID.Saudi);
    }

    @Then("^Subscription Plans should be displayed$")
    public void subscription_Plans_should_be_displayed(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
homePage.validte_Plans_Section_Isdisplayed(driver);
    }

    @Then("^Saudi Subscriptions Should have types$")
    public void saudi_Subscriptions_Should_have_types(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,0) , Subscription_Type.Lite.toString());
Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,1) , Subscription_Type.Classic.toString());
Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,2) , Subscription_Type.Premium.toString());


    }

    @When("^the user selects the Bahrain country$")
    public void the_user_selects_the_Bahrain_country(WebDriver driver) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage.Select_Country(driver , Country_ID.Bahrain);
    }

    @Then("^Bahrain Subscriptions Should have types$")
    public void bahrain_Subscriptions_Should_have_types(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
        Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,1) , Subscription_Type.Lite.toString());
        Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,2) , Subscription_Type.Classic.toString());
        Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,3) , Subscription_Type.Premium.toString());

    }

    @When("^the user selects the Kuwait country$")
    public void the_user_selects_the_Kuwait_country(WebDriver driver) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage.Select_Country(driver , Country_ID.Kuwait);
    }

    @Then("^Kuwait Subscriptions Should have types$")
    public void kuwait_Subscriptions_Should_have_types(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
        Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,1) , Subscription_Type.Lite.toString());
        Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,2) , Subscription_Type.Classic.toString());
        Validate.assertEquals( homePage.get_Subscription_plan_Text(driver ,3) , Subscription_Type.Premium.toString());

    }

    @Then("^Every Subscription Should have pric Saudi e$")
    public void every_Subscription_Should_have_price_Saudi(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
        Validate.assertEquals( homePage.Get_Prices_Saudi(driver ,1 , Saudi_Prices.Classic) , Saudi_Prices.Classic.toString());
        Validate.assertEquals( homePage.Get_Prices_Saudi(driver ,0 , Saudi_Prices.Lite) , Saudi_Prices.Lite.toString());
        Validate.assertEquals( homePage.Get_Prices_Saudi(driver ,2 , Saudi_Prices.Premium) , Saudi_Prices.Premium.toString());
    }

    @Then("^Every Subscription Should have pric Kuwait e$")
    public void every_Subscription_Should_have_price_Kuwait(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
        Validate.assertEquals( homePage.Get_Prices_Kuwait(driver ,0 ,Kuwait_Prices.Lite) , Kuwait_Prices.Lite.toString());
        Validate.assertEquals( homePage.Get_Prices_Kuwait(driver ,1 , Kuwait_Prices.Classic) , Kuwait_Prices.Classic.toString());
    }

    @Then("^Every Subscription Should have pric Bahrin$")
    public void every_Subscription_Should_have_price_Bahrain(WebDriver driver) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        Validate.assertEquals( homePage.Get_Prices_Bahrain(driver ,0 , Bahrain_Prices.Lite) , Bahrain_Prices.Lite.toString());
        Validate.assertEquals( homePage.Get_Prices_Bahrain(driver ,1 ,Bahrain_Prices.Classic ) , Bahrain_Prices.Classic.toString());
    }


    @Then("^Currency Should be SAR for Saudi$")
    public void currency_Should_be_SAR(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
        Validate.assertTrue( homePage.Get_Currency(driver ,Currencies.Saudi).contains(Currencies.Saudi.toString())== true);
        Validate.assertTrue( homePage.Get_Currency(driver,Currencies.Saudi).contains(Currencies.Saudi.toString())== true);
        Validate.assertTrue( homePage.Get_Currency(driver ,Currencies.Saudi).contains(Currencies.Saudi.toString())== true);


    }

    @Then("^Currency Should be SAR for Kuwait$")
    public void currency_Should_be_KW(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
        Validate.assertTrue( homePage.Get_Currency(driver ,Currencies.Kuwait).contains(Currencies.Kuwait.toString())== true);
        Validate.assertTrue( homePage.Get_Currency(driver,Currencies.Kuwait).contains(Currencies.Kuwait.toString())== true);
        Validate.assertTrue( homePage.Get_Currency(driver ,Currencies.Kuwait).contains(Currencies.Kuwait.toString())== true);


    }

    @Then("^Currency Should be SAR for Bahrain$")
    public void currency_Should_be_BH(WebDriver driver) {
        // Write code here that turns the phrase above into concrete actions
        Validate.assertTrue( homePage.Get_Currency(driver ,Currencies.Bahrain).contains(Currencies.Bahrain.toString())== true);
        Validate.assertTrue( homePage.Get_Currency(driver,Currencies.Bahrain).contains(Currencies.Bahrain.toString())== true);
        Validate.assertTrue( homePage.Get_Currency(driver ,Currencies.Bahrain).contains(Currencies.Bahrain.toString())== true);


    }

    public WebDriver Capabilities() throws MalformedURLException {
        WebDriver driver ;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get(" https://subscribe.stctv.com/sa-en");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        return driver;
    }



    // Objects


    @BeforeClass
    public void initializeClassTestData() throws InterruptedException, IOException {


        driver = Capabilities();
        HomePage homePage = new HomePage();
        Subscribtion_Steps subscription_Steps = new Subscribtion_Steps();
        Thread.sleep(4000);
    }


    @BeforeMethod
    public void initializeClassTestCaseData() throws MalformedURLException {
        driver = Capabilities();




    }


    @AfterMethod
    public void clearTestData(ITestResult result) {
        driver.close();

    }

    @AfterClass
    public void clearTestClassTestData() throws InterruptedException {

        driver.quit();
    }







    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String ReadScreenTexts() throws TesseractException {
        String imgName = takeScreenShot();
        String result = null;
        File imageFile = new File(scrShotDirPath, imgName);
        System.out.println("Image name is :" + imageFile.toString());
        ITesseract instance = new Tesseract();

        File tessDataFolder = LoadLibs.extractTessResources("tessdata");

        instance.setDatapath(tessDataFolder.getAbsolutePath());

        result = instance.doOCR(imageFile);
        System.out.println(result);
        return result;
    }

    public String takeScreenShot(){

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(scrShotDir).mkdirs();
        destFile = dateFormat.format(new Date()) + ".png";

        try {
            FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile));

        } catch (IOException e) {
            System.out.println("Image not transfered to screenshot folder");
            e.printStackTrace();
        }
        return destFile;
    }


}

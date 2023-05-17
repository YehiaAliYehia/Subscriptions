package TestBases;
import AppPages.CatalogListPage;
import AppPages.CreateCatalogPage;
import AppPages.HomePage;
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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase  {
    static String scrShotDir = "bugsrecorder/screenshots";
    File scrFile;
    static File scrShotDirPath = new java.io.File("./" + scrShotDir + "//");
    String destFile;
    protected WebDriver driver;
    protected  CatalogListPage catalogListPage;
    protected  CreateCatalogPage createCatalogPage;

    // Alaa Code 9-2020

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
        catalogListPage = new CatalogListPage();
        createCatalogPage = new CreateCatalogPage();
        HomePage homePage = new HomePage();
        Thread.sleep(4000);
    }


    @BeforeMethod
    public void initializeClassTestCaseData() throws MalformedURLException {
     //   driver = Capabilities();




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




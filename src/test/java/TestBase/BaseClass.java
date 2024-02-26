package TestBase;
/*
* 1.4: Create BaseClass under testBase package and copy re-usable methods.
1.5: Create re-usable methods to generate random numbers and strings in BaseClass.
*/

import org.apache.commons.lang3.RandomStringUtils;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;//log4j

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import static java.util.logging.LogManager.*;

/*To implement log4j.xml prerequisites are log4j.jar files are attached from pom.xml downloaded and log4j properties are to add the xml file  */
/*log4j setup things are put in base class and should import the correct log4j
* Logging - record all the events in the form of text.

Log Levels - All < Trace < Debug < Info < Warn < Error < Fatal < Off


Appenders - where to generate logs (Console/File)
Loggers  - what type of logs generate (All < Trace < Debug < Info < Warn < Error < Fatal < Off)
 */
public class BaseClass {
    public WebDriver driver;
    public Logger logger;

    public Properties p;

    @BeforeClass(groups = {"sanity", "regression", "master"})
    /*3.1: Create testng.xml file to Run Test Cases and parameterize browser name and OS to BaseClass →setup() method.
3.2: Update BaseClass →setup() method, launch browser based on conditions.
3.3: Maintain separate xml to run tests multiple browsers parallelly.
*/
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {
        /*4.1: Add config.properties file under src/test/resoures.
4.2: Update BaseClass →setup() method, add script to load config.properties file.
4.3: Replace hard coded values in Test Cases like url, username, password etc...
*/
        //loading properties file
        FileReader file = new FileReader("C:\\Users\\DELL\\Lavanya\\Automation\\SeleniumFramework\\src\\test\\resources\\config.properties");
        p = new Properties();
        p.load(file);

        //loading log4j2 file
        logger = LogManager.getLogger(this.getClass());//Log4j

        //standalone setup for selenium grid
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("NO matching os...");

            }


            //loading browser based on condition
            switch (br.toLowerCase()) {
                case "chrome" : capabilities.setBrowserName("chrome"); break;
                case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
                default: System.out.println("No matching browser.."); return;
            }

            //driver=new ChromeDriver();
            //Standalone Setup (Single machine):selenium grid
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        } else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("No matching browser..");
                    return;
            }


        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // WebDriverWait mywait=new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();


    }

    @AfterClass(groups = {"sanity", "regression", "master"})
    public void tearDown() {
        driver.quit();
    }


    public String randomeString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomeNumber() {
        String generatedString = RandomStringUtils.randomNumeric(10);
        return generatedString;
    }

    public String randomAlphaNumeric() {
        String str = RandomStringUtils.randomAlphabetic(3);
        String num = RandomStringUtils.randomNumeric(3);

        return (str + "@" + num);
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

}

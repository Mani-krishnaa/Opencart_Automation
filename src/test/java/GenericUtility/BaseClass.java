package GenericUtility;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public Properties p;

    //  public ExcelUtility ex = new ExcelUtility();
    @BeforeClass(groups = {"Sanity", "Regression", "Master"})
    @Parameters({"os", "browser"})
    public void setup() throws IOException {
        //loading config.prpprties file

        FileReader file = new FileReader("/home/manikrishna/Intellij/Open_cartAutomation/src/test/resources/config.propirties");
        p = new Properties();
        p.load(file);

        driver = new ChromeDriver();

//        switch (br.toLowerCase()) {
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//            default:
//                System.out.println("Invalid Browser Name");
//                return;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(p.getProperty("appurl")); //reading url from proprties file
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Sanity", "Regression", "Master"})
    public void teardown() {
        driver.close();
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaString() {
        String generatedStrinfg = RandomStringUtils.randomAlphabetic(5);
        String generatednum = RandomStringUtils.randomNumeric(10);

        return generatedStrinfg + "@" + generatednum;
    }

    public String captureSceen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "//screenshots//" + tname + "_" + timeStamp + ".png";

        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);

        return  targetFilePath;
    }
}

package afterSuiteXmlExample;

import com.miczhao.github.allureTools.environmentCreator.AllureXmlEnvironmentWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class FixturesOne {

    public WebDriver chromeDriver;

    @BeforeMethod
    public void beforeMethod(){
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com/");
    }

    @AfterMethod
    public void afterMethod(){
        chromeDriver.quit();
    }

    @AfterSuite
    public void afterSuite(){
        HashMap<String,String> allureEnvironment = new HashMap<>();
        allureEnvironment.put("Browser","Chrome");
        allureEnvironment.put("Version","102.648.743");
        allureEnvironment.put("Stand URL","http://test.com");

        AllureXmlEnvironmentWriter allureXmlEnvironmentWriter = new AllureXmlEnvironmentWriter();
        allureXmlEnvironmentWriter.createAllureEnvironment(allureEnvironment);
    }
}

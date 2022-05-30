package genericLib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
    static WebDriver driver=null;
    public static WebDriver openBrowser(String url)
    {

        if(Utility.getpropertykeyvalue("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome browser opened");
        }
        else if(Utility.getpropertykeyvalue("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firefox browser opened");
        }
        else if(Utility.getpropertykeyvalue("browser").equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Edge browser opened");
        }
        else if(Utility.getpropertykeyvalue("browser").equalsIgnoreCase("ie"))
        {
            WebDriverManager.iedriver().setup();
            driver= new InternetExplorerDriver();
            System.out.println("IE browser opened");
        }
        else if(Utility.getpropertykeyvalue("browser").equalsIgnoreCase("safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver= new SafariDriver();
            System.out.println("Safari browser opened");
        }
        else {
            System.out.println("Please Enter Valid Browser Name as in properties file");
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}

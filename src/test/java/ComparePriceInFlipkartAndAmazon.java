import genericLib.Base;
import genericLib.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ComparePriceInFlipkartAndAmazon extends Base {

    static String productName = "REDMI Note 10 Pro (Dark Night, 128 GB) (6 GB RAM)";

    @Test
    public void fetchPrice(){
        Integer priceInFlipkart = fetchPriceInFlipkart();
        System.out.println("Price in Flipkart for the specified product is "+priceInFlipkart);
        Integer priceInAmazon = fetchPriceInAmazon();
        System.out.println("Price in Amazon for the specified product is "+priceInAmazon);
        if (priceInAmazon.equals(priceInFlipkart))
        {
            System.out.println("Price in Amazon and Flipkart are same");
        }
        else if(priceInFlipkart>priceInAmazon)
        {
            System.out.println("Price in flipkart is more");
        }
        else
            System.out.println("Price is amazon is more");

    }
    public static Integer fetchPriceInFlipkart()
    {
        WebDriver driver = openBrowser(Utility.getpropertykeyvalue("flipkartURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.findElement(By.xpath("//button[text()='✕']")).click();
        driver.findElement(By.xpath(Utility.getElement("search"))).sendKeys(productName, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Utility.getElement("priceInFlipkart")))));
        String priceInFlipkart = driver.findElement(By.xpath(Utility.getElement("priceInFlipkart"))).getText();
        priceInFlipkart = priceInFlipkart.replaceAll("[^a-zA-Z0-9]", "");
        Integer price = Integer.valueOf(priceInFlipkart);
        driver.quit();
        return price;
    }
    public static Integer fetchPriceInAmazon()
    {
        WebDriver driver = openBrowser(Utility.getpropertykeyvalue("amazonURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.findElement(By.id(Utility.getElement("searchField"))).sendKeys(productName, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Utility.getElement("priceInAmazon")))));
        String priceInAmazon = driver.findElement(By.xpath(Utility.getElement("priceInAmazon"))).getText();
        priceInAmazon = priceInAmazon.replaceAll("[^a-zA-Z0-9]", "");
        Integer price = Integer.valueOf(priceInAmazon);
        driver.quit();
        return price;
    }




}

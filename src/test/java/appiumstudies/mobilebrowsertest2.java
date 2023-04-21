package appiumstudies;

import Base.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mobilebrowsertest2 extends BaseBrowser {
    @Test
    public void MobileBrowser () throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.cssSelector("li:nth-of-type(1) > .nav-link")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)","");
        String text = driver.findElement(By.xpath("//a[@href='/angularAppdemo/products/3']")).getText();
        Thread.sleep(3000);
        Assert.assertEquals(text,"Devops");

        
    }
}

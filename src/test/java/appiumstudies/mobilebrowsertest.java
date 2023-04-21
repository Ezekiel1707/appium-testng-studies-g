package appiumstudies;

import Base.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class mobilebrowsertest extends BaseBrowser {
    @Test
    public void MobileBrowser () throws InterruptedException {

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);


    }
}

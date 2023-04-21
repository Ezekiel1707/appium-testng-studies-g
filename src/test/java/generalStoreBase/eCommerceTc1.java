package generalStoreBase;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class eCommerceTc1 extends BaseTest2{
    @Test
    public void FillForm () throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Joan Jons");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();

//        WebElement Country = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Anguilla']"));
//        scrollFromElement(Country,"down",4.0);
//        if (driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).isDisplayed()){
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
//        }

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);


    }
}

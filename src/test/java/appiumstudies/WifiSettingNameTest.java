package appiumstudies;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WifiSettingNameTest extends BaseTest {

    @Test
    public void WifiSettingName() throws MalformedURLException {

        //para darle click al app, usar appium inspector y luego con los selectors igual que con selenium
        //driver.findElement(By.) esto es generico, selenium
        //Appium soporta solo Xpath, id, accesibilityId, classname, androidUIautomator
        // metodo comun de escribir xpath
        //  //tagName[@attribute='value']
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();

        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Jon Wifi");
        //usando classname
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}

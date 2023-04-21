package appiumstudies;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class OtherAppiumAction extends BaseTest {

    @Test
    public void RotationTest () throws MalformedURLException {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        //rotar el telefono

        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();

        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Jon Wifi");
        //usando classname
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }

    @Test
    public void clipBoardtest () throws MalformedURLException {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        //rotar el telefono

        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();

        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.setClipboardText("Jon Wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        //usando classname
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }

    @Test
    public void pressKeysTest () throws MalformedURLException {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        //rotar el telefono

        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();

        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.setClipboardText("Jon Wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        //usando classname
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }
}

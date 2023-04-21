package appiumstudies;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ActivitiesTest extends BaseTest {

    @Test
    public void activityTest () throws MalformedURLException {

        // comand y cmd para ver cual es el package name y la actividad(windows)
        //adb shell dumpsys window | find "mCurrentFocus"
        //crear la actividad y luego indicarselo al driver

        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);

        //por lo que pusimos antes nos podemos saltar esto ya que empezamos desde donde queremos probar rapidamente
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
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

}

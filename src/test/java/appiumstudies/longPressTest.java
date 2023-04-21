package appiumstudies;

import Base.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class longPressTest extends BaseTest {

    @Test
    public void longPress() throws MalformedURLException {

        //para darle click al app, usar appium inspector y luego con los selectors igual que con selenium
        //driver.findElement(By.) esto es generico, selenium
        //Appium soporta solo Xpath, id, accesibilityId, classname, androidUIautomator
        // metodo comun de escribir xpath
        //  //tagName[@attribute='value']
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement elem = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        //para hacer gestos complicados se necesita usar javascript, UiAutomator2 tiene opciones ya agregadas
        //para diferentes gestos buscar la documentación en internet

//        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
//                ImmutableMap.of("elementId",((RemoteWebElement)elem).getId(),"duration",2000));
        //esto es lo mismo que arriba pero generico desde el basetest
        longClickGestureToElement(elem,2000);

        String menuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

    }
}

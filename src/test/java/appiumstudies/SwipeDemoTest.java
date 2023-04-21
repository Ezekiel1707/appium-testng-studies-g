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

public class SwipeDemoTest extends BaseTest {
//dos formas
    @Test
    public void swipeDemo() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
        WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
        //Swipe

//        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
//                ImmutableMap.of("elementId",((RemoteWebElement)firstImage)
//                        .getId(),
//                        "direction","left",
//                        "percent",0.75));
        //lo que esta arriba se llevo a el Basepage, esto es dando elementId, pero tambien puede cambiarse por coordenadas
        swipeActionByElement(firstImage,"left",0.75);
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
        //Swipe
        Thread.sleep(2000);
    }

}

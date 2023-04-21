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

public class DragAndDropTest extends BaseTest {
//dos formas
    @Test
    public void DragAndDrop() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc= 'Drag and Drop']")).click();
        //lo que quiero mover
        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //hacer el drag and drop con el elementId

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 620,
                "endY", 560));

        Thread.sleep(3000);

        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result,"Dropped!");
    }

    @Test
    public void DragAndDrop2() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc= 'Drag and Drop']")).click();
        //lo que quiero mover
        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //hacer el drag and drop con el elementId

        dragAndDropByElement(source,620,560);

        Thread.sleep(3000);

        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result,"Dropped!");
    }

    @Test
    public void DragAndDrop3() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc= 'Drag and Drop']")).click();
        //lo que quiero mover
        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //hacer el drag and drop con el elementId

        dragAndDropByCoordinates(208,560,620,560);

        Thread.sleep(3000);

        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result,"Dropped!");
    }
}

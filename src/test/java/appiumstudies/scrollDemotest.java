package appiumstudies;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class scrollDemotest extends BaseTest {
//dos formas
    @Test
    public void scrolldemo1() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //usando androidUiAutomator y puede buscarse el texto
        driver. findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"WebView\"));"));


        Thread.sleep(2000);
    }
    @Test
    public void scrolldemo2() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //usando Appium se usando coordenadas, puede usarse un elementId, pero si no se sabe si esta puede
        //usarse coordenadas
//        boolean canScrollMore;
//        do {
//            canScrollMore = (boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
//                    ImmutableMap.of("left",100,"top",100,"width",200,"height",200,
//                            "direction","down",
//                            "percent",3.0));
//        }while (canScrollMore);

        //para hacer scroll hasta el final. se puede hacer una sola función y luego crear condiciones
        //para que se detenga
        scrollToEndAction("down",3.0);

        Thread.sleep(2000);
    }

    @Test
    public void scrolldemo3() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement webV = driver.findElement(AppiumBy.accessibilityId("WebView"));
        scrollToElement(webV,"down",3.0);

        Thread.sleep(2000);
    }
}

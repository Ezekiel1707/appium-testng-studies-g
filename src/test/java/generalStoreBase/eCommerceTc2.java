package generalStoreBase;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class eCommerceTc2 extends BaseTest2{
    @Test
    public void toastMessage () throws MalformedURLException, InterruptedException {

        //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Joan Jons");
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

        //en androis todos los toast message estan escritos asi: android.widget.Toast, para mas de uno en pantalla
        //ponerle el index con [], con esto se puede escribir un xpath

        String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
        Thread.sleep(2000);



    }
}

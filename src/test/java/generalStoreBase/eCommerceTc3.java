package generalStoreBase;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class eCommerceTc3 extends BaseTest2{
    @Test
    public void addToCart () throws MalformedURLException, InterruptedException {

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

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Jordan 6 Rings\"));"));

        int productsInView = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int i=0; i<productsInView;i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if(productName.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }

        }

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cart']")),"text","Cart"));

        String productAdded = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(productAdded,"Jordan 6 Rings");
        Thread.sleep(2000);
    }
}

package generalStoreBase;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class eCommerceTc5 extends BaseTest2{
    @Test
    public void buyTest () throws MalformedURLException, InterruptedException {
        By a = AppiumBy.id("com.androidsample.generalstore:id/nameField");
        driver.findElement(a).sendKeys("Joan Jons");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        int productsInView = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int i=0; i<productsInView;i++){
            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cart']")),"text","Cart"));
        List<WebElement> productsPrices= driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        int productsInCart = productsPrices.size();
        double sum=0;
        for(int i=0; i<productsInCart;i++) {

            String amountString = productsPrices.get(i).getText();
            double price = Double.parseDouble(amountString.substring(1));
            sum = sum + price;
        }
        String Total = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        double Totalprice = Double.parseDouble(Total.substring(1));
        Assert.assertEquals(Totalprice,sum);

        WebElement elem = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
        longClickGestureToElement(elem,2000);
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(2000);

    }
}

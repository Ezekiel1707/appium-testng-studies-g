package generalStoreBase;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class eCommerceTc6 extends BaseTest2{
    @Test
    public void hybridApp () throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Joan Jons");
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
        Thread.sleep(4000);

        //Hybrid app

        //driver.getContextHandles();
        //se necesita obtener el nombre correctamente
        Set<String> context = driver.getContextHandles();
        for (String contextName : context){
            System.out.println(contextName);
        }
        //Aqui estoy cambiando al buscarod del app hibrido
        //Aqui esta usando un driver viejo de chrome por como esta hecho el app de prueba.
        driver.context("WEBVIEW_com.androidsample.generalstore");
        Thread.sleep(4000);
        driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //Aqui estoy regresando a el APP
        driver.context("NATIVE_APP");


    }
}

package appiumstudies;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class appiumBasics {

    @Test
    public void appiumTest() throws MalformedURLException {
        //esto para crear y abrir el servidor de Appium
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//ezeki//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //aqui estamos abriendo en el emulador el apk del app a probar creando las opciones
        UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName("Gphone");
        options.setApp("D://Documents//appiumStudies//appiumstudies1//appiumstudies1//src//test//java//resources//ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        //para darle click al app, usar appium inspector y luego con los selectors igual que con selenium
        //driver.findElement(By.) esto es generico, selenium
        //Appium soporta solo Xpath, id, accesibilityId, classname, androidUIautomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        // aqui cerrando el driver del app y del appium
        driver.quit();
        service.stop();

    }
}

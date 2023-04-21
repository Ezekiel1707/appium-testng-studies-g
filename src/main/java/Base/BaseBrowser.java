package Base;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseBrowser {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium()throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//ezeki//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        //aqui estamos abriendo el servicio de appium
        service.start();

        //aqui estamos abriendo en el emulador el apk del app a probar creando las opciones
        UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName("Gphone");
        //Revisar si el cambio en directorio funciona
        options.setChromedriverExecutable(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\chromedriver.exe");
        options.setCapability("browserName","chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
        service.stop();
    }



}

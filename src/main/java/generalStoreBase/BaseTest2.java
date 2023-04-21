package generalStoreBase;

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

public class BaseTest2 {

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
        options.setApp(System.getProperty("user.dir") +"\\src\\test\\java\\resources\\General-Store.apk");
        options.setChromedriverExecutable(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\chromedriver.exe");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
        service.stop();
    }

//recordar buscar todos gestos posibles y escribir funciones para elementId y para coordenadas
    public void longClickGestureToElement(WebElement element, int time){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element)
                        .getId(),"duration",time));
    }

    public void longClickGestureToPoint(int x,int y, int time){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("x",x,"y",y,"duration",time));
    }

    public void doubleClickGestureToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: doubleClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element)
                        .getId()));
    }

    public void doubleClickGestureToPoint(int x,int y){
        ((JavascriptExecutor)driver).executeScript("mobile: doubleClickGesture",
                ImmutableMap.of("x",x,"y",y));
    }
    public void scrollToEndAction(String direction, double percent){
        boolean canScrollMore;
        do {
            canScrollMore = (boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left",100,"top",100,"width",200,"height",200,
                            "direction",direction,
                            "percent",percent));
        }while (canScrollMore);
    }

    public void scrollFromElement(WebElement element, String direction, double percent){
        boolean canScrollMore;
        do {
            canScrollMore = (boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                            "direction",direction,
                            "percent",percent));
        }while (canScrollMore);
    }
    public void swipeActionByElement(WebElement element, String direction, double percent){

        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element)
                                .getId(),
                        "direction",direction,
                        "percent",percent));
    }
    public void dragAndDropByElement(WebElement element, int endX, int endY){

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY));
    }
    public void dragAndDropByCoordinates(int startX, int startY, int endX, int endY){

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX,
                "startY", startY,
                "endX", endX,
                "endY", endY));
    }

}

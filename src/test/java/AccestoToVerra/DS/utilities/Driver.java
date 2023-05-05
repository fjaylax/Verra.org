package AccestoToVerra.DS.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    Driver(){}
   static InheritableThreadLocal<WebDriver>driverPool= new InheritableThreadLocal<>();
    public static  WebDriver getDriver(){

        if(driverPool.get()== null){

            String browserType=ConfigurationReader.getProperty("browser");


            WebDriverManager.chromedriver().setup();
            driverPool.set(new ChromeDriver());
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }

        return driverPool.get();
    }




    public static void closeDriver(){
    if(driverPool.get() !=null)
        driverPool.get().quit();
    driverPool.remove();
}
}

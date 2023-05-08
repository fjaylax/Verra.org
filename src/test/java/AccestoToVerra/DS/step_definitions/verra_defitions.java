package AccestoToVerra.DS.step_definitions;

import AccestoToVerra.DS.utilities.ConfigurationReader;
import AccestoToVerra.DS.utilities.Driver;
import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class verra_defitions {

    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("chrome"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement report = Driver.getDriver().findElement(By.xpath("//a[@role='button']"));
        report.click();

        WebElement carbon = Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/div/a[1]/span"));
        carbon.click();

        WebElement searchBtn = Driver.getDriver().findElement(By.xpath("//*[@id=\"search_sel_id\"]"));
        searchBtn.sendKeys("4358");

        WebElement searchBtn1 = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        searchBtn1.click();

        WebElement jobName = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Xiangyang AWMS GHG Mitigation Project in Hubei Pro')]"));
        jobName.click();

        // verify
        String expectedTitle = "Verra Search Page";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        String expectedUrl = "https://registry.verra.org/app/projectDetail/VCS/4358";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        String s = Driver.getDriver().getCurrentUrl();
        String url = "https://registry.verra.org/app/projectDetail/VCS/4358";
        if (s.equals(url)) {
            System.out.println("Page Loaded");
            System.out.println("Current Url: " + s);
        } else {
            System.out.println("Page did not load");
        }
        Driver.getDriver().quit();
    }
}

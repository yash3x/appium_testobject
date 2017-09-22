import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Sample_Test {

    AppiumDriver driver;

    @BeforeSuite
    public void Setup() throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("deviceName", "LG Nexus 5X Free");
        caps.setCapability("phoneOnly", "false");
        caps.setCapability("tabletOnly", "false");
        caps.setCapability("privateDevicesOnly", "false");
        caps.setCapability("testobject_api_key", "FCA3FEB972F7416D94C426FDEF42DD03");
        caps.setCapability("appiumVersion", "1.6.5");
        caps.setCapability("testobject_cache_device", "false");
        caps.setCapability("testobject_session_creation_timeout", "900000");
        caps.setCapability("testobject_app_id", "2");
        caps.setCapability("testobject_suite_name", "Default Appium Suite");
        caps.setCapability("testobject_test_name", "Default Appium Test");
        caps.setCapability("noReset", "true");
        caps.setCapability("autoGrantPermissions", "true");


        driver = new AppiumDriver(new URL("https://eu1.appium.testobject.com/wd/hub"), caps);

    }


    @Test
    public void DemoTest() throws InterruptedException {
        while (true) {
            try {
                new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Tap to cast\"]")));
                System.out.println("[DIAGNAL] Cast tour is displayed");
                driver.findElement(By.id("com.balaji.alt:id/drawer_layout")).click();
                break;

            } catch (Exception e) {
                System.out.println("[DIAGNAL] Cast tour is not displayed");
                break;
            }
        }
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@resource-id=\"com.balaji.alt:id/main_toolbar\"]/android.widget.ImageButton[1]")).click();
        driver.findElement(By.xpath("//*[@resource-id=\"com.balaji.alt:id/switchTKidsLabel\"]")).click();
        Thread.sleep(5000);

        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.balaji.alt:id/dialog_sign_in_button")));
        Assert.assertTrue("SIGN IN AND SUBSCRIBE NOW".equalsIgnoreCase(driver.findElement(By.id("com.balaji.alt:id/dialog_sign_in_button")).getText()));
        System.out.println("[DIAGNAL] SIGN IN AND SUBSCRIBE NOW is displayed");
        Thread.sleep(5000);

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(10000);
    }
}

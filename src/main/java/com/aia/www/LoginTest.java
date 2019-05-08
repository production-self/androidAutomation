package com.aia.www;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LoginTest {

    private AppiumDriver driver;

    private  void init() throws Exception {
        //set the env properties
        DesiredCapabilities cap = new DesiredCapabilities();
        //set the platform
        cap.setCapability("platformName", "Android");
        //set the device name ,can get the name through the adb command
        cap.setCapability("deviceName", "29e14e04");
        //set the platform version
        cap.setCapability("platformVersion", "5");
        //set the automation name
        cap.setCapability("automationName", "UiAutomator2");
        //set the capablity name
        cap.setCapability("appPackage", "com.aia.sg.mypage.oneapp.wrapper.myaiasg");
        //set the activity name
        cap.setCapability("appActivity", "com.aia.sg.mypage.oneapp.wrapper.myaiasg.Launch");
        cap.setCapability("sessionOverride", true);
        //config the driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }


    private void plus() throws InterruptedException {
        //wait for load the view
        Thread.sleep(15000);
        //fill in the usename
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"NRIC\"]")).sendKeys("G3202632F");
        //fill in the password
        driver.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Login\"]/android.view.View/android.view.View[5]/android.widget.EditText")).sendKeys("Test123#");
        //click the commit button
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"SUBMIT\"]")).click();
    }


    public void tearDown() throws Exception {
        //quit the appium session
        driver.quit();

    }

    public static void main(String[] args) throws Exception {
        LoginTest loginTest = new LoginTest();
        loginTest.init();
        loginTest.plus();
    }
}

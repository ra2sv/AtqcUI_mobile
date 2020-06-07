package com.atqc.tests.mobile;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleTest {
    
    @Test
    public void firstSimpleTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("settings[enableMultiWindows]", true);
        capabilities.setCapability("app", "E:\\Automation\\Lect\\ApiDemos-debug.apk"); //set full path to apk
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName", "UiAutomator2");

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement appElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("App"));
        appElement.click();

        MobileElement alarmElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Alarm"));
        alarmElement.click();

        MobileElement alarmController = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Alarm Controller"));
        alarmController.click();

        MobileElement oneShotElement = (MobileElement) driver.findElement(MobileBy.id("one_shot"));
        oneShotElement.click();

        MobileElement toastMessage = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.Toast"));
        String toastText = "One-shot alarm will go off in 30 seconds based on the real time clock. Try changing the current time before then!";
        assertThat("Text is equal", toastMessage.getText(), is(toastText));

        driver.quit();

    }

    @Test
    public void secondSimpleTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("settings[enableMultiWindows]", true);
        capabilities.setCapability("app", "E:\\Automation\\Lect\\ApiDemos-debug.apk"); //set full path to apk
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName", "UiAutomator2");

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement appElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("App"));
        appElement.click();

        MobileElement fragment = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Fragment"));
        fragment.click();

        MobileElement contextMenu = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Context Menu"));
        contextMenu.click();

        MobileElement longPressMe = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Long press me"));

        longPressOnElement(driver,longPressMe);

        List<MobileElement> elements = driver.findElements(MobileBy.id("android:id/title"));

        assertThat("Context elements equals",elements.size(),is(2));

        assertThat("Text is equal", elements.get(0).getText(), is("Menu A"));
        assertThat("Text is equal", elements.get(1).getText(), is("Menu B"));

        elements.get(0).click();

        MobileElement toastMessage = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.Toast"));
        String toastText = "Item 1a was chosen";
        assertThat("Text is equal", toastMessage.getText(), is(toastText));

        driver.quit();

    }

    public void longPressOnElement(AndroidDriver driver, MobileElement firstNameField) {
        new TouchAction(driver)
                .longPress(longPressOptions().withElement(element(firstNameField))
                        .withDuration(Duration.ofMillis(2000))).release().perform();
    }

}

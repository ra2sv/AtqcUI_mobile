package framework;

import io.appium.java_client.*;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static framework.PlatformFactory.getDriver;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

@Log4j
public class Utilities {

    public static WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public static void longPressOnElement(MobileElement firstNameField) {
        new TouchAction((PerformsTouchActions) getDriver())
                .longPress(longPressOptions().withElement(element(firstNameField))
                        .withDuration(Duration.ofMillis(2000))).release().perform();
    }

    public static String getToastMessage() {
        return getDriver().findElement(MobileBy.xpath("//android.widget.Toast")).getText();
    }

    public static void scrollUp() {
        Dimension size = getDriver().manage().window().getSize();

        int startVerticalY = (int) (size.height * 0.8);
        int endVerticalY = (int) (size.height * 0.30);
        int startVerticalX = (int) (size.width / 2.1);

        new TouchAction<>((AppiumDriver) getDriver()).press(point(startVerticalX, startVerticalY))
                .waitAction(waitOptions(ofSeconds(2))).moveTo(point(startVerticalX, endVerticalY)).release()
                .perform();
    }

    public static boolean isVisible(MobileElement element) {
        try {
            element(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public static void elementIsNotPresent(String xpath) throws InterruptedException {
        for (int i = 0; i <= 5; ++i) {
            if (getDriver().findElements(By.xpath(xpath)).isEmpty()) {
                System.out.println("Element disappeared");
                break;
            } else {
                System.out.println("Element still visible");
            }
            if(i==5) System.out.println("Element not disappeared");
        }
    }
}

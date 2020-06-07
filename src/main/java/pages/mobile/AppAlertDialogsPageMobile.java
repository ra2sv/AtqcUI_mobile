package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import java.util.List;

import static framework.PlatformFactory.getDriver;

@Log4j
public class AppAlertDialogsPageMobile extends BasePageMobile {

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(accessibility = "OK Cancel dialog with a message")
    private MobileElement menu01Element;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(accessibility = "OK Cancel dialog with a long message")
    private MobileElement menu02Element;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(accessibility = "List dialog")
    private MobileElement menu04Element;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
    private List<MobileElement> menuItems;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
    private MobileElement alertTitle;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    private MobileElement alertMessage;


    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(xpath = "//android.widget.Button[2]")
    private MobileElement okButton;


    @Step("Click on 'OK Cancel dialog with a long message'")
    public AppAlertDialogsPageMobile clickMenu01() {
        menu01Element.click();
        return new AppAlertDialogsPageMobile();
    }

    @Step("Click on 'OK Cancel dialog with a message'")
    public AppAlertDialogsPageMobile clickMenu02() {
        menu02Element.click();
        return new AppAlertDialogsPageMobile();
    }

    @Step("Click on 'List dialog'")
    public AppAlertDialogsPageMobile clickMenu04() {
        menu04Element.click();
        return new AppAlertDialogsPageMobile();
    }

    @Step("Get alert Title")
    public String getAlertTitle() {
        return alertTitle.getText();
    }

    @Step("Get alert Message")
    public String getAlertMessage() {
        return alertMessage.getText();
    }

    @Step("Click on 'OK' button")
    public AppAlertDialogsPageMobile clickOkButton() {
        okButton.click();
        log.info("Click on 'OK' button");
        return new AppAlertDialogsPageMobile();
    }

    @Step("Get count of menu items")
    public int getCountOfMenuItems() {
        return getDriver().findElements(MobileBy.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).size();
    }

    @Step("Click on menu items by index: {0}")
    public AppAlertDialogsPageMobile clickOnMenuItemsByIndex(int i) {
        menuItems.get(i).click();
        log.info("Select menu item by index");
        return new AppAlertDialogsPageMobile();
    }

    @Step("Get text from item by index: {0}")
    public String getTextMenuItemByIndex(int i) {
        return menuItems.get(i).getText();
    }

}

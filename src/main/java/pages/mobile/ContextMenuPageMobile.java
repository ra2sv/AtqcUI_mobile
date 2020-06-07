package pages.mobile;

import framework.Utilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import java.util.List;

import static framework.PlatformFactory.getDriver;

public class ContextMenuPageMobile extends BasePageMobile {

    @AndroidFindBy(accessibility = "Long press me")
    private MobileElement longPressMeButton;

    @AndroidFindBy(id = "android:id/title")
    private List<MobileElement> menuElements;

    @Step("Long press on 'Long press me' button")
    public void longPressOnLongPressMeButton() {
        Utilities.longPressOnElement(longPressMeButton);
    }

    @Step("Get count of menu")
    public int getCountOfMenuElements() {
        return getDriver().findElements(MobileBy.id("android:id/title")).size();
    }

    @Step("Click on menu element by index: {0}")
    public void clickOnMenuElementByIndex(int i) {
        menuElements.get(i).click();
    }

    @Step("Get text from element by index: {0}")
    public String getTextElementByIndex(int i) {
        return menuElements.get(i).getText();
    }
}

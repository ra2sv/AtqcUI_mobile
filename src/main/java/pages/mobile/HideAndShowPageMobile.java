package pages.mobile;

import framework.Utilities;
import framework.Wait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import java.util.List;

import static framework.PlatformFactory.getDriver;

@Log4j
public class HideAndShowPageMobile extends BasePageMobile {


    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc='Hide'])[1]")
    private MobileElement firstHideButton;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc='Hide'])[2]")
    private MobileElement secondHideButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='io.appium.android.apis:id/msg']")
    private List<MobileElement> fieldTitles;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc='Initial text.'])")
    private List<MobileElement> inputFields;


    @Step("Click on first 'Hide' button")
    public HideAndShowPageMobile clickFirstHideButton() {
        firstHideButton.click();
        log.info("Click on first 'Hide' button");
        return new HideAndShowPageMobile();
    }

    @Step("Get name of the first Action button")
    public String getFirstNameActionButton() {
        return firstHideButton.getText();
    }

    @Step("Click on second 'Hide' button")
    public HideAndShowPageMobile clickSecondHideButton() {
        secondHideButton.click();
        log.info("Click on second 'Hide' button");
        return new HideAndShowPageMobile();
    }

    @Step("Get name of the first Action button")
    public String getSecondNameActionButton() {
        return secondHideButton.getText();
    }

    @Step("Get count of title")
    public int getCountOfTitle() {
        return getDriver().findElements(MobileBy.xpath("//android.widget.TextView[@resource-id='io.appium.android.apis:id/msg']")).size();
    }

    @Step("Get text from item by index: {0}")
    public String getTextFielTitleByIndex(int i) {
        return fieldTitles.get(i).getText();
    }

    @Step("Get count of InputFields")
    public int getCountOfInputFields() {
        return getDriver().findElements(MobileBy.xpath("(//android.widget.EditText[@content-desc='Initial text.'])")).size();
    }

    @Step("Get text from item by index: {0}")
    public String getInputFieldsTextByIndex(int i) {
        return inputFields.get(i).getText();
    }

    @Step("Wait until first files disappears")
    public HideAndShowPageMobile waitDisappearFirstTitle() throws InterruptedException {
        Utilities.elementIsNotPresent("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        return new HideAndShowPageMobile();
    }

    @Step("Wait until second files disappears")
    public HideAndShowPageMobile waitDisappearSecondTitle() throws InterruptedException {
        Utilities.elementIsNotPresent("//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");
        return new HideAndShowPageMobile();
    }

}

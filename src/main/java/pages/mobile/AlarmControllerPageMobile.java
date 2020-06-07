package pages.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class AlarmControllerPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "one_shot")
    private MobileElement oneShotAlarmButton;

    @Step("Click on 'One Shot' button")
    public void clickOneShotAlarmButton() {
        oneShotAlarmButton.click();
    }
}

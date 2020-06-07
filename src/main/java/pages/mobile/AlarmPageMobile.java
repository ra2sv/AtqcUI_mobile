package pages.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class AlarmPageMobile extends BasePageMobile {

    @AndroidFindBy(accessibility = "Alarm Controller")
    private MobileElement alarmControllerElement;

    @Step("Click on 'Alarm Controller'")
    public AlarmControllerPageMobile clickAlarmControllerElement() {
        alarmControllerElement.click();
        return new AlarmControllerPageMobile();
    }


}

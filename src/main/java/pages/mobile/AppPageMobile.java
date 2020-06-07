package pages.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class AppPageMobile extends BasePageMobile {

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(accessibility = "Alarm")
    private MobileElement alarmElement;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(accessibility = "Fragment")
    private MobileElement fragmentElement;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(accessibility = "Alert Dialogs")
    private MobileElement alertDialogsElement;

    @Step("Click on 'Alarm'")
    public AlarmPageMobile clickAlarmElement() {
        alarmElement.click();
        return new AlarmPageMobile();
    }

    @Step("Click on 'Fragment'")
    public FragmentPageMobile clickFragmentElement() {
        fragmentElement.click();
        return new FragmentPageMobile();
    }

    @Step("Click on 'Alert Dialogs' menu")
    public FragmentPageMobile clickAlertDialogElement() {
        alertDialogsElement.click();
        return new FragmentPageMobile();
    }

}

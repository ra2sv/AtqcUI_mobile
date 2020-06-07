package pages.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class APIDemoPageMobile extends BasePageMobile {

    @AndroidFindBy(accessibility = "App")
    private MobileElement appElement;

    @Step("Click on 'App'")
    public AppPageMobile clickOnAppElement() {
        appElement.click();
        return new AppPageMobile();
    }
}

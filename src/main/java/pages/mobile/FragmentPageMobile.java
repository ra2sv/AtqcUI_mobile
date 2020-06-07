package pages.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class FragmentPageMobile extends BasePageMobile {

    @AndroidFindBy(accessibility = "Context Menu")
    private MobileElement contextMenuElement;


    @AndroidFindBy(accessibility = "Hide and Show")
    private MobileElement hideAndShowElement;

    @Step("Click on 'Context menu' menu")
    public ContextMenuPageMobile clickContextMenuElement() {
        contextMenuElement.click();
        return new ContextMenuPageMobile();
    }

    @Step("Click on 'Hide and Show' menu")
    public ContextMenuPageMobile clickHideAndShowElement() {
        hideAndShowElement.click();
        return new ContextMenuPageMobile();
    }

}

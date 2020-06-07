package com.atqc.tests.mobile;

import com.atqc.tests.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.mobile.*;

import static framework.PlatformFactory.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class T01AlertDialogsTest extends BaseTest {

    APIDemoPageMobile apiDemoPageMobile;
    AppPageMobile appPageMobile;
    AppAlertDialogsPageMobile appAlertDialogsPageMobile;

    @Test(priority = 1, description = ("App/alert dialogs (dialog window)"))
    public void appAlert_01() {

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        appPageMobile.clickAlertDialogElement();

        appAlertDialogsPageMobile = new AppAlertDialogsPageMobile();
        appAlertDialogsPageMobile.clickMenu01();

        String titleText = "Lorem ipsum dolor sit";
        assertThat(appAlertDialogsPageMobile.getAlertTitle(), containsString(titleText));

        appAlertDialogsPageMobile.clickOkButton();
    }

    @Test(priority = 2, description = ("App/alert dialogs (dialog window)"))
    public void appAlert_02() {

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        appPageMobile.clickAlertDialogElement();

        appAlertDialogsPageMobile = new AppAlertDialogsPageMobile();
        appAlertDialogsPageMobile.clickMenu02();

        String titleText = "Header title";
        assertThat(appAlertDialogsPageMobile.getAlertTitle(), containsString(titleText));

        String alertMessage = "Plloaso mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno. Whag schengos, uf efed, quiel ba mada su otrenzr.";
        assertThat(appAlertDialogsPageMobile.getAlertMessage(), containsString(alertMessage));

        appAlertDialogsPageMobile.clickOkButton();
    }

    @Test(priority = 3, dataProvider = "Menu items", description = ("App/alert dialogs (dialog window)"))
    public void appAlert_03(int item, String menuName) {

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        appPageMobile.clickAlertDialogElement();

        appAlertDialogsPageMobile = new AppAlertDialogsPageMobile();
        appAlertDialogsPageMobile.clickMenu04();

        String titleText = "Header title";
        assertThat(appAlertDialogsPageMobile.getAlertTitle(), containsString(titleText));
        assertThat("Quantity of menu equals", appAlertDialogsPageMobile.getCountOfMenuItems(), is(4));
        assertThat("Name of menu item is correct", appAlertDialogsPageMobile.getTextMenuItemByIndex(item), containsString(menuName));

        String menuMessage = appAlertDialogsPageMobile.getTextMenuItemByIndex(item);
        appAlertDialogsPageMobile.clickOnMenuItemsByIndex(item);
        assertThat("Text is equal", appAlertDialogsPageMobile.getAlertMessage(), containsString(menuMessage));
        getDriver().navigate().back();
    }

    @DataProvider(name = "Menu items")
    public Object[][] dataProviderMethod() {
        return new Object[][] { {0, "Command one"}, {1, "Command two"}, {2, "Command three"}, {3, "Command four"} };
    }

}

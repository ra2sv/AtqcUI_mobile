package com.atqc.tests.mobile;

import com.atqc.tests.BaseTest;
import framework.Utilities;
import org.testng.annotations.Test;
import pages.mobile.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MobileAppTest extends BaseTest {

    AppPageMobile appPageMobile;
    AlarmPageMobile alarmPageMobile;
    AlarmControllerPageMobile alarmControllerPageMobile;
    FragmentPageMobile fragmentPageMobile;
    ContextMenuPageMobile contextMenuPageMobile;

    @Test
    public void testForAlarmController(){

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        alarmPageMobile = appPageMobile.clickAlarmElement();
        alarmControllerPageMobile = alarmPageMobile.clickAlarmControllerElement();
        alarmControllerPageMobile.clickOneShotAlarmButton();

        String toastText = "One-shot alarm will go off in 30 seconds based on the real time clock. Try changing the current time before then!";
        assertThat("Text is equal", Utilities.getToastMessage(), is(toastText));

    }

    @Test
    public void testForFragmentContextMenu(){

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        fragmentPageMobile = appPageMobile.clickFragmentElement();
        contextMenuPageMobile = fragmentPageMobile.clickContextMenuElement();
        contextMenuPageMobile.longPressOnLongPressMeButton();

        assertThat("Context elements equals",contextMenuPageMobile.getCountOfMenuElements(),is(2));
        assertThat("Text is equal", contextMenuPageMobile.getTextElementByIndex(0), is("Menu A"));
        assertThat("Text is equal", contextMenuPageMobile.getTextElementByIndex(1), is("Menu B"));

        contextMenuPageMobile.clickOnMenuElementByIndex(0);

        String toastText = "Item 1a was chosen";
        assertThat("Text is equal", Utilities.getToastMessage(), is(toastText));
    }

}






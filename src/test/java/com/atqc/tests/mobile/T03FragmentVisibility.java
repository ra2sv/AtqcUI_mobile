package com.atqc.tests.mobile;

import com.atqc.tests.BaseTest;
import org.testng.annotations.Test;
import pages.mobile.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class T03FragmentVisibility extends BaseTest {

    AppPageMobile appPageMobile;
    FragmentPageMobile fragmentPageMobile;
    ContextMenuPageMobile contextMenuPageMobile;
    HideAndShowPageMobile hideAndShowPageMobile;

    @Test
    public void testFragmentVisibility() throws InterruptedException {

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        fragmentPageMobile = appPageMobile.clickFragmentElement();
        contextMenuPageMobile = fragmentPageMobile.clickHideAndShowElement();

        hideAndShowPageMobile = new HideAndShowPageMobile();

        assertThat("Title elements equals",hideAndShowPageMobile.getCountOfTitle(),is(2));
        assertThat("Input field elements equals",hideAndShowPageMobile.getCountOfInputFields(), is(2));

        hideAndShowPageMobile.clickFirstHideButton();
        hideAndShowPageMobile.waitDisappearFirstTitle();

        hideAndShowPageMobile.getCountOfTitle();
        assertThat("Title elements equals", hideAndShowPageMobile.getCountOfTitle(), is(1));
        assertThat("Input field elements equals", hideAndShowPageMobile.getCountOfInputFields(), is(1));
        assertThat("Name of the first button equals", hideAndShowPageMobile.getFirstNameActionButton(), is("Show"));


        hideAndShowPageMobile.clickSecondHideButton();
        hideAndShowPageMobile.waitDisappearSecondTitle();

        hideAndShowPageMobile.getCountOfTitle();
        assertThat("Title elements equals", hideAndShowPageMobile.getCountOfTitle(), is(0));
        assertThat("Input field elements equals", hideAndShowPageMobile.getCountOfInputFields(), is(0));
        assertThat("Name of the second button equals", hideAndShowPageMobile.getSecondNameActionButton(), is("Show"));

        hideAndShowPageMobile.clickFirstHideButton();
        hideAndShowPageMobile.clickSecondHideButton();
        assertThat("Title elements equals",hideAndShowPageMobile.getCountOfTitle(),is(2));
        assertThat("Input field elements equals",hideAndShowPageMobile.getCountOfInputFields(), is(2));

        assertThat("Title elements of the first field equals",hideAndShowPageMobile.getTextFielTitleByIndex(0), is("The fragment saves and restores this text."));
        assertThat("Title elements of the second field equals",hideAndShowPageMobile.getTextFielTitleByIndex(1), is("The TextView saves and restores this text."));
        assertThat("Name of the first button equals", hideAndShowPageMobile.getFirstNameActionButton(), is("Hide"));
        assertThat("Name of the second button equals", hideAndShowPageMobile.getSecondNameActionButton(), is("Hide"));

    }
}

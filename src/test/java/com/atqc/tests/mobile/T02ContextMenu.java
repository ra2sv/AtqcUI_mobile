package com.atqc.tests.mobile;


import com.atqc.tests.BaseTest;
import framework.Utilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.mobile.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class T02ContextMenu extends BaseTest {

    AppPageMobile appPageMobile;
    FragmentPageMobile fragmentPageMobile;
    ContextMenuPageMobile contextMenuPageMobile;


    @Test (dataProvider = "ContextMenu")
    public void testFragmentContextMenu(int item, String menuName, String toastText){

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        fragmentPageMobile = appPageMobile.clickFragmentElement();
        contextMenuPageMobile = fragmentPageMobile.clickContextMenuElement();
        contextMenuPageMobile.longPressOnLongPressMeButton();

        assertThat("Context elements equals",contextMenuPageMobile.getCountOfMenuElements(),is(2));
        assertThat("Text is equal", contextMenuPageMobile.getTextElementByIndex(item), is(menuName));

        contextMenuPageMobile.clickOnMenuElementByIndex(item);

        assertThat("Text is equal", Utilities.getToastMessage(), is(toastText));
    }

    @DataProvider(name = "ContextMenu")
    public Object[][] dataProviderMethod() {
        return new Object[][] { {0, "Menu A", "Item 1a was chosen"}, {1, "Menu B", "Item 1b was chosen"}};
    }
}

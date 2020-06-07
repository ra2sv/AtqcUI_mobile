package pages.mobile;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static framework.PlatformFactory.getDriver;

public abstract class BasePageMobile {

    public BasePageMobile() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

}

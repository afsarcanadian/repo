package pageObjects;

import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class Login extends CommonMethods {

    public Login(){
        PageFactory.initElements(driver, this);
    }
}

package helpers;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class TestHelpers {

    public static String getPathFromWhereApplicationIsRunning() throws Exception {
        try {
            return new File(".").getCanonicalPath();
        } catch (IOException ex) {
            throw new Exception("Failed to get the absolute path of the process.",ex);
        }
    }

    public static void clickOnElement(WebElement element){
        element.click();
    }

}

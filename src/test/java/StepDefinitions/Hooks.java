package StepDefinitions;

import Utilities.BasicDriver;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    @Before
    public void beforeScenario() {
        System.out.println("Scenerio has started");

    }

    @After // This method runs after every scenario
    public void afterScenario(Scenario scenario) {
        System.out.println("Scenario has ended");
        if (scenario.isFailed()) {

           final byte[] bytesImage=((TakesScreenshot)BasicDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytesImage,"image/png",scenario.getName());
//            TakesScreenshot takesScreenshot = (TakesScreenshot) BasicDriver.getDriver();
//            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
//            LocalDateTime timeOfError = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
//            try {
//                FileUtils.copyFile(file, new File("src/test/java/ScreenShots/screenshot"
//                        + timeOfError.format(formatter) + ".png"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }
        BasicDriver.quitDriver();
    }

}
//
//    @BeforeStep
//    public void beforeStep() {
//        System.out.println("step has started");
//    }
//
//    @AfterStep
//    public void afterStep() {
//        System.out.println("step has ended");
//    }
//}
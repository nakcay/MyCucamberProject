package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;


@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class _08_RunnerForExtendReportWithScreenShots extends AbstractTestNGCucumberTests {


    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("User.name"));
        ExtentService.getInstance().setSystemInfo("Time zone", System.getProperty("User.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", System.getProperty("John Snow"));
        ExtentService.getInstance().setSystemInfo("Application Name", " Campus");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Additional Line", "Additional info");
    }

}


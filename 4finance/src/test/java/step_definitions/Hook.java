package step_definitions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.DataUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hook {

    private DataUtils dataUtils;

    public Hook(DataUtils dataUtils) {
        this.dataUtils = dataUtils;
    }

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.ANY);
        String address = "http://localhost:4444/wd/hub";
        dataUtils.driver = new RemoteWebDriver(new URL(address), capabilities);
        dataUtils.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dataUtils.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        dataUtils.driver.close();
    }
}

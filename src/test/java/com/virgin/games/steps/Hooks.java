package com.virgin.games.steps;

import com.virgin.games.propertyreader.PropertyReader;
import com.virgin.games.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {

    @Before
    public void setUp() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = getScreenShot();
            scenario.attach(screenshot, "image/jpg", scenario.getName());
        }
        closeBrowser();
    }
}

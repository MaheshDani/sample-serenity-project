package sample.project.utils;

import org.apache.commons.lang.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "uk.gov.ho.cts.utils.*")
public class DriverTest {
    private WebDriver webDriver;
    private Driver driverUnderTest;

    @Before
    public void setUp() {
        driverUnderTest = new Driver();
    }

    @Test
    public void testDriverWithChromeBrowser() throws Exception {
        FieldUtils.writeField(driverUnderTest, "browser", "chrome", true);
        webDriver = driverUnderTest.newDriver();
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();

        assertThat("testDriverWithChromeBrowser() : ", cap.getBrowserName().toLowerCase(), is("chrome"));
        webDriver.quit();
    }

    @Test
    public void testDriverWithChromeBrowserOnLinux() throws Exception {
        FieldUtils.writeField(driverUnderTest, "browser", "chrome", true);
        FieldUtils.writeField(driverUnderTest, "os", "Linux", true);
        webDriver = driverUnderTest.newDriver();
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();

        assertThat("testDriverWithChromeBrowser() : ", cap.getBrowserName().toLowerCase(), is("chrome"));
        webDriver.quit();
    }

    @Test
    public void testDriverWithFirefoxBrowser() throws Exception {
        FieldUtils.writeField(driverUnderTest, "browser", "firefox", true);

        System.setProperty("webdriver.gecko.driver", "src/test/resources/testDrivers/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        webDriver = driverUnderTest.newDriver();
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
        assertThat("testDriverWithFirefoxBrowser() : ", cap.getBrowserName().toLowerCase(), is("firefox"));
        webDriver.quit();
    }

    @Test
    public void testDriverWithPhantomJSBrowser() throws Exception {
        FieldUtils.writeField(driverUnderTest, "browser", "phantomjs", true);
        System.setProperty("phantomjs.binary.path", "src/test/resources/testDrivers/phantomjs.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "src/test/resources/testDrivers/phantomjs.exe");

        webDriver = driverUnderTest.newDriver();
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();

        assertThat("testDriverWithPhantomJSBrowser() : ", cap.getBrowserName().toLowerCase(), is("phantomjs"));
        webDriver.quit();
//        System.setProperty("webdriver.phantomjs.driver", "src/test/resources/testDrivers/phantomjs.exe");
    }


    public void testDriverWithEdgeBrowser() throws Exception {
        FieldUtils.writeField(driverUnderTest, "browser", "edge", true);
        System.setProperty("webdriver.edge.driver", "src/test/resources/testDrivers/msedgedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        capabilities.setCapability("marionette", true);

        webDriver = driverUnderTest.newDriver();
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
        assertThat("testDriverWithEdgeBrowser() : ", cap.getBrowserName().toLowerCase(), is("edge"));
        webDriver.quit();
    }

    @Test
    public void testDriverWithInternetExplorerBrowser() throws Exception {
        FieldUtils.writeField(driverUnderTest, "browser", "ie", true);
        System.setProperty("webdriver.ie.driver", "src/test/resources/testDrivers/IEDriverServer.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("marionette", true);

        webDriver = driverUnderTest.newDriver();
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
        assertThat("testDriverWithInternetExplorerBrowser() : ", cap.getBrowserName().toLowerCase(), is("internet explorer"));
        webDriver.quit();
    }

    @Test
    public void testDriverWithDefaultBrowserType() throws Exception {
        FieldUtils.writeField(driverUnderTest, "browser", "", true);
        webDriver = driverUnderTest.newDriver();
        if (webDriver != null) {
            Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
            assertThat("testDriverWithDefaultBrowserType() : ", cap.getBrowserName().toLowerCase(), is("chrome"));
            webDriver.quit();
        }
    }

    @Test
    public void testTakeScreenshot() throws Exception {
        assertThat("testTakeScreenshot() : ", driverUnderTest.takesScreenshots(), is(true));
    }

}

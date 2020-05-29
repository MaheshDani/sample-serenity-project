package sample.project.utils;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver implements DriverSource {

    private static final Logger LOG = LoggerFactory.getLogger("Driver.class");
    String os = System.getProperty("os.name");
    String browser = Configuration.get("webdriver.browser");


    private static final Logger LOGGER = LoggerFactory.getLogger(Driver.class);


    @Override
    public WebDriver newDriver() {

        switch (browser) {
            case "chrome":
                LOGGER.info("setting webdriver browser to : chrome");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--no-first-run");
                if (os.contains("Linux")) {
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-gpu");
                }
                return new ChromeDriver(options);
            default:
                return null;
        }
    }

    private ChromeOptions getDefaultChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--no-first-run");
        options.addArguments("--window-size=1920,1080");
        if (os.contains("Linux")) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
        } else if (os.contains("Windows")) {
            options.addArguments("start-maximized");
        }
        return options;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}

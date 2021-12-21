package models;

import base.Application;
import base.factory.DriverFactory;
import models.configuration.EnvironmentConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.ConfigProvider;

import java.time.Duration;

public class BaseTest {
    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected static EnvironmentConfig environmentConfig = ConfigProvider.getConfig();
    protected Application application;


    @BeforeEach
    void setUp() {
        driver = new DriverFactory().getDriverOptions(Browsers.valueOf(environmentConfig.getBrowser()));
        logger.info("Driver initialized with additional options");
        actions = new Actions(driver);
        logger.info("Action initialized");
        int waitValue = Integer.parseInt(environmentConfig.getWait());
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitValue));
        logger.info("WaitDriver with " + waitValue + "secs value initialized");
        application = new Application(driver);
    }

    @AfterEach
    void tearDown() {
        application.close();
    }
}
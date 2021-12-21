package pages;

import models.WebListener;
import models.configuration.EnvironmentConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.ConfigProvider;

import java.time.Duration;

public abstract class BasePage {
    private Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected Actions actions;
    protected EnvironmentConfig environmentConfig;
    protected WebDriverWait webDriverWait;
    private EventFiringMouse eventFiringMouse;
    private WebListener webListener;

    public BasePage(WebDriver driver) {
        environmentConfig = ConfigProvider.getConfig();
        webListener = new WebListener();
        this.driver = driver;
        this.actions = new Actions(driver);
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(environmentConfig.getWait())));
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement elementToClick){
        String elementText = elementToClick.getText();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
        logger.info("Clicked on webelement {}", elementText);
    }

    public void sendKeysToElement(WebElement elementToSendKeys, String keyToSend){
        elementToSendKeys.clear();
        webDriverWait.until(ExpectedConditions.visibilityOf(elementToSendKeys)).sendKeys(keyToSend);
        logger.info("String {} sent to {} element", keyToSend, elementToSendKeys.getAttribute("class"));
    }

    public void mouseHover(WebElement element, String loggerValueToRead){
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) webDriverWait.until(ExpectedConditions.visibilityOf(element));
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        logger.info("Mouse cursor moved to {} element", element.getAttribute(loggerValueToRead));
    }
}

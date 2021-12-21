package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class IFrameProductPage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(IFrameProductPage.class);

    @FindBy(css = "#thumbs_list_frame a")
    private List<WebElement> thumbImagesList;

    public IFrameProductPage cycleThoughProductImages(){
        webDriverWait.until(ExpectedConditions.visibilityOf(thumbImagesList.get(0)));
        for (WebElement element : thumbImagesList) {
            try {
                mouseHover(element, "class");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public IFrameProductPage switchToIFrame(){
        driver.switchTo().frame(0);
        logger.info("Switched to new iframe window");
        return this;
    }

    public IFrameProductPage(WebDriver driver) {
        super(driver);
    }
}

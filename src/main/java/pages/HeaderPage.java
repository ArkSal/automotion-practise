package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderPage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(HeaderPage.class);

    @FindBy(css = "[title='Women']:not(img)")
    private WebElement womenCategoryButton;

    @FindBy(css = "[title='Blouses']")
    private WebElement blousesSubcategoryButton;

    public ProductMiniaturesGridPage goToBlousesCatalog() {
        clickOnElement(blousesSubcategoryButton);
        return new ProductMiniaturesGridPage(driver);
    }

    public HeaderPage mouseHoverWomen() {
        logger.info("Mouse hover on clothes link");
        mouseHover(womenCategoryButton, "title");
        return this;
    }

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
}

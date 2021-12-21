package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductMiniaturePage {
    private Logger logger = LoggerFactory.getLogger(ProductMiniaturePage.class);

    public ProductMiniaturePage(WebElement productMiniature) {
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
    }

    @FindBy(css = ".img-responsive")
    private WebElement imageWindow;

    @FindBy(css = ".quick-view")
    private WebElement quickViewButton;

    public WebElement getQuickViewButton() {
        return quickViewButton;
    }

    public WebElement getImageWindow(){
        return imageWindow;
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductMiniaturesGridPage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(HeaderPage.class);

    public ProductMiniaturesGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.product-container")
    private List<WebElement> productMiniatures;

    public List<ProductMiniaturePage> createProductMiniaturesList(){
        List<ProductMiniaturePage> productMiniatureList = new ArrayList<>();
        for (WebElement product : productMiniatures){
            productMiniatureList.add(new ProductMiniaturePage(product));
        }
        logger.info("List of product miniatures created");
        return productMiniatureList;
    }

    public IFrameProductPage clickQuickViewOnFirstMiniature(){
        ProductMiniaturePage productMiniature = createProductMiniaturesList().get(0);
        mouseHover(productMiniature.getImageWindow(), "title");
        productMiniature.getQuickViewButton().click();
        logger.info("Quick view icon on product miniature clicked");
        return new IFrameProductPage(driver);
    }
}

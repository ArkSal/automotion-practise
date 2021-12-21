package models;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductMiniatureTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(ProductMiniatureTest.class);

    @Test
    void cyclingThroughWomenBlousesCategoryImages() {
        application.open()
                .mouseHoverWomen()
                .goToBlousesCatalog()
                .clickQuickViewOnFirstMiniature()
                .switchToIFrame()
                .cycleThoughProductImages();
    }
}

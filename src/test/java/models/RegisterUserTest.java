package models;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterUserTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(RegisterUserTest.class);

    @Test
    void loginWithNonExistingUser(){
        application.open()
                .mouseHoverWomen()
                .goToBlousesCatalog()
                .clickQuickViewOnFirstMiniature()
                .switchToIFrame()
                .cycleThoughProductImages();
    }
}

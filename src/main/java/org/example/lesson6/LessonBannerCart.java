package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LessonBannerCart extends LessonRootPage{
    public LessonBannerCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='View my shopping cart']//span[@class='ajax_cart_quantity']")
    private WebElement checkCart;

    public void checkAssert() {
        Assertions.assertEquals(checkCart.getText(), "1");
    }
}

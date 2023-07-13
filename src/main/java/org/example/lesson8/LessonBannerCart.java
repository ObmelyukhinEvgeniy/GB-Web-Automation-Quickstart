package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LessonBannerCart {
    private final SelenideElement checkCart = $(By
            .xpath("//a[@title='View my shopping cart']//span[@class='ajax_cart_quantity']"));

    public void checkAssert() {
        Assertions.assertAll(
                () -> checkCart.shouldHave(text("1"))
        );
    }
}

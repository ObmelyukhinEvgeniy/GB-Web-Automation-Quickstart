package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LessonMyAccountPage {
    private final SelenideElement buttonWomen = $(By.xpath("//a[@title='Women']"));
    private final SelenideElement linkTShirts = $(By
            .xpath("//div[@id='block_top_menu']//li[1]//a[@title='T-shirts']"));
    @Step("Кликаем по ссылке 'TShirts' в подменю 'Women'")
    public void clickLinkTShirts() {
        buttonWomen.hover();
        linkTShirts.click();
    }
}

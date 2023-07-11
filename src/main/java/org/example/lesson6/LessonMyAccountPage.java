package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LessonMyAccountPage extends LessonRootPage {
    public LessonMyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement buttonWomen;

    @FindBy(xpath = "//div[@id='block_top_menu']//li[1]//a[@title='T-shirts']")
    private WebElement linkTShirts;

    @Step("Кликаем по ссылке 'TShirts' в подменю 'Women'")
    public void clickLinkTShirts() {
        actions
                .moveToElement(buttonWomen)
                .click(linkTShirts)
                .build()
                .perform();
    }
}

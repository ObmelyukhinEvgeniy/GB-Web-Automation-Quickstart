package org.example.autodoc;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutodocBuyPage extends AutodocRootPage{

    public AutodocBuyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='partNumberSearch']")
    private WebElement fieldPartNumberSearch; //Поле поиска артикула детали на ГС.

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch; //Кнопка "Поиск" на ГС

    @FindBy(xpath = "//td[contains(text(), 'MANN')]/parent::tr")
    private WebElement buttonSelectionBrand; //Кнопка уточнения искомого бренда.

    @FindBy(xpath = "//app-price-table[@header='Запрошенный номер в офисе регистрации']//a[@id='addToCart']")
    private WebElement iconAddToCart; //Иконка "Добавить в корзину"

    @FindBy(xpath = "//input[@id='btnAddToCart']")
    private WebElement buttonAddPart; //Кнопка "Добавить"

    //Метод добавляет деталь в корзину

    public void addPartToCart(String part) throws InterruptedException {
        fieldPartNumberSearch.sendKeys(part);
        buttonSearch.click();
        Thread.sleep(3000);
        buttonSelectionBrand.click();
        Thread.sleep(3000);
        iconAddToCart.click();
        buttonAddPart.click();
    }

    public void checkAddPart() {
        Assertions.assertTrue(driver
                .findElement(By.xpath("//a[contains(text(),' W 67/1 ')]")).isDisplayed());
    }
}

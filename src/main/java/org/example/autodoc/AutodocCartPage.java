package org.example.autodoc;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutodocCartPage extends AutodocRootPage {

    public AutodocCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@routerlinkactive='active-link' and @href='/cart']")
    private WebElement linkCart; //Ссылка "Корзина" в хедаре.

    @FindBy(xpath = "//thead//span[@class='icon fa']")
    private WebElement checkboxGeneral; //Чекбокс общий.

    @FindBy(xpath = "//tbody//tr[1]//span[@class='icon fa']")
    private WebElement checkboxFirst; //Чекбокс первый с товаром

    @FindBy(xpath = "//button[@class='button button-buy']")//css = ".button.button-buy")
    private WebElement buttonPlaceOrder; //Кнопка "Оформить заказ"

    @FindBy(xpath = "//h2[contains(.,'Оформлен заказ на сумму')]")
    private WebElement headerH2PlacedOrder; //Заголовок 'Оформлен заказ на сумму'

    @FindBy(xpath = "//span[text()='Заказы']")
    private WebElement linkOrders; //Ссылка "Заказы" в хедаре

    @FindBy(xpath = "//div[text()='На модерации']")
    private WebElement titleStatusOrderOnModeration; //Статус заказа "На модерации"

    @FindBy(xpath = "//tr[1]//button[@icon='pi pi-ellipsis-v']")
    private WebElement iconActionMenuFirst; //Иконка "Три точки" первая сверху на странице "Заказы"

    @FindBy(xpath = "//button[text()='Отказаться']")
    private WebElement buttonRefuse; //Кнопка "Отказаться"

    @FindBy(xpath = "//button[@label='Да']")
    private WebElement buttonYesRefuseOrder; //Кнопка "Да" Отказаться от заказа

    @FindBy(xpath = "//tr[1]//div[text()='Заказ снят']")
    private WebElement titleStatusOrderRefuse; //Статус заказа "Заказ снят"

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");

    }

    public void orderPartFromCart() throws InterruptedException {
        linkCart.click();
        Thread.sleep(3000);
        checkboxGeneral.click();
        Thread.sleep(3000);
        checkboxFirst.click();
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonPlaceOrder);//Проскролить страницу до элемента buttonPlaceOrder(Кнопка "Оформить заказ")
        Thread.sleep(5000);
        buttonPlaceOrder.click();
        Thread.sleep(3000);
    }

    public void checkOrder() {
        Assertions.assertTrue(headerH2PlacedOrder.isDisplayed());
    }

    public void checkStatusOrderOnModeration() {
        Assertions.assertTrue(titleStatusOrderOnModeration.isDisplayed());
    }

    public void refuseOrder() {
        linkOrders.click();
        iconActionMenuFirst.click();
        buttonRefuse.click();
        buttonYesRefuseOrder.click();
    }

    public void checkStatusOrderRefuse() {
        Assertions.assertTrue(titleStatusOrderRefuse.isDisplayed());
    }
}

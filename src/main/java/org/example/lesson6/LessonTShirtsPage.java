package org.example.lesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LessonTShirtsPage extends LessonRootPage {

    public LessonTShirtsPage(WebDriver driver) {
        super(driver);
    }

    //Передаём в поле checkboxSML список из трёх элементов
    @FindBy(xpath = "//ul[contains(@id,'ul_layered_id_attribute_group')]//a[contains(@href, 'size')]")
    private List<WebElement> checkboxSML;

    public LessonTShirtsPage selectSize(String size) {
        //(stream)Получаем поток данных.
        //(filter(a->a.getText().contains(size)))Далее отфильтровываем в списке только те элементы
        //у которых текст содержит то что мы передадим в size.
        //(findFirst)выбираем из списка только один первый попавшийся элемент.
        //(get)получаем его и (click)выполняем клик по нему.
        checkboxSML.stream().filter(a->a.getText().contains(size)).findFirst().get().click();
        return this;
    }

    //Работаем с элементом слайдер
    //Нашли  xpath крайнего левого элемента
    @FindBy(xpath = "//div[@id='layered_price_slider']/a[1]")
    private WebElement selectLeftSlider;

    //Вместо void возвращаем страницу T-Shirts
    public LessonTShirtsPage selectPrice(int offsetX) {
        //Хватаем ползунок и смещаем его по оси Х на энное кол-во пикселей, по оси У на 0.
        actions
                .dragAndDropBy(selectLeftSlider, offsetX, 0)
                .build()
                .perform();
        //Возвращаем эту же страницу
        return this;
    }

    @FindBy(xpath = "//a[@class='product_img_link']")
    private WebElement selectProduct;

    @FindBy(xpath = "//a[@title='Add to cart']")
    private WebElement addProduct;

    @FindBy(xpath = "//a[@title='Close']")
    private WebElement buttonClose;

    @Step("Наводим курсор на товар")
    public void addProductCart() {
        actions
                .moveToElement(selectProduct)
                //.click(addProduct)
                //.click(buttonClose)
                .build()
                .perform();
    }

    @Step("Проверяем появление кнопки 'Add to cart'")
    public void checkTest() {
        Assertions.assertTrue(addProduct.isDisplayed());
    }
}

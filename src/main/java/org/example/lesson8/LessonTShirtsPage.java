package org.example.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LessonTShirtsPage {
    //Передаём в поле checkboxSML список из трёх элементов
    private final ElementsCollection checkboxSML = $$(By
            .xpath("//ul[contains(@id,'ul_layered_id_attribute_group')]//a[contains(@href, 'size')]"));

    public LessonTShirtsPage selectSize(String size) {
        //(stream)Получаем поток данных.
        //(filter(a->a.getText().contains(size)))Далее отфильтровываем в списке только те элементы
        //у которых текст содержит то что мы передадим в size.
        //(findFirst)выбираем из списка только один первый попавшийся элемент.
        //(get)получаем его и (click)выполняем клик по нему.
        //checkboxSML.stream().filter(a->a.getText().contains(size)).findFirst().get().click();
        checkboxSML.findBy(Condition.text(size)).click();
        return this;
    }

    //Работаем с элементом слайдер
    //Нашли  xpath крайнего левого элемента
    private final SelenideElement selectLeftSlider = $(By
            .xpath("//div[@id='layered_price_slider']/a[1]"));
    //Вместо void возвращаем страницу T-Shirts
    public LessonTShirtsPage selectPrice(int offsetX) {
        //Хватаем ползунок и смещаем его по оси Х на энное кол-во пикселей, по оси У на 0.
        actions().dragAndDropBy(selectLeftSlider, offsetX, 0).perform();
        //Возвращаем эту же страницу
        return this;
    }
    private final SelenideElement selectProduct = $(By
            .xpath("//a[@class='product_img_link']"));
    private final SelenideElement addProduct = $(By
            .xpath("//a[@title='Add to cart']"));
    private final SelenideElement buttonClose = $(By
            .xpath("//a[@title='Close']"));
    @Step("Наводим курсор на товар")
    public void addProductCart() {
        selectProduct.hover();
    }
    @Step("Проверяем появление кнопки 'Add to cart'")
    public void checkTest() {
        Assertions.assertAll(
                () -> addProduct.shouldBe(visible)
        );
    }
}

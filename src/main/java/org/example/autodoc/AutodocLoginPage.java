package org.example.autodoc;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutodocLoginPage extends AutodocRootPage {

    //Конструктор пренимающий объект driver из класса AutodocRootPage
    public AutodocLoginPage(WebDriver driver) {
        super(driver);
    }

    //Создаём список элементов-полей в стиле pageObject для страницы "Логин"
    @FindBy(xpath = "//a[contains(text(),'Личный кабинет')]")
    private WebElement linkPersonalCabinet; //Ссылка 'Личный кабинет' на ГС.

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement fieldLogin; //Поле "Логин".

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement fieldPassword; //Поле "Пароль"

    @FindBy(xpath = "//button[text()=' Вход ']")
    private WebElement buttonSignIn;

    //Метод выполняющий вход в личный кабинет(ЛК)
    @Step("Вход в личный кабинет")
    public void autodocSignIn(String login, String password) {
        linkPersonalCabinet.click();
        fieldLogin.sendKeys(login);
        fieldPassword.sendKeys(password);
        buttonSignIn.click();
    }
}

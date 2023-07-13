package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LessonLoginPage {

    //Создаём список элементов-полей в стиле BDD/Gherkin/Selenide
    private final SelenideElement emailField = $(By.id("email"));
    private final SelenideElement passwordField = $(By.id("passwd"));
    private final SelenideElement signInButton = $(By.id("SubmitLogin"));
    @Step("Выполнен вход в ЛК")
    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}

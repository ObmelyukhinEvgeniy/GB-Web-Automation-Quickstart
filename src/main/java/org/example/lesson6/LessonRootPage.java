package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LessonRootPage {
    //Объявляем поля
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    //При создании каждой страницы будем передавать driver и на основе этого driver инициализируем
    //все остальные параметры
    public LessonRootPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        //Регестрирует страницу как PageObject и повторно обновляет поля-элементы когда  мы хотим к ним обратиться
        PageFactory.initElements(driver, this);
    }
}

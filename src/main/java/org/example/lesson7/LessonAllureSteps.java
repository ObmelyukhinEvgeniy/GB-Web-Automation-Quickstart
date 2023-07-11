package org.example.lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class LessonAllureSteps implements WebDriverListener {
    //Добавляем логирование
    private static final Logger logger = LoggerFactory.getLogger("Selenium");

    public void beforeClick(WebElement element) {
        //Воводит сообщение в консоль
        logger.info("Кликаем" + element.getText());
        //Добавляет инфу в отчёт Allure
        Allure.step("Кликаем" + element.getText());


    }

    //Скриншот страницы перед каждым действием, сохраняется в байтах и передаётся в отчёт
/*    public void beforeFindElement(WebDriver driver, By locator) {
        Allure.addAttachment
                ("Скриншот перед поиском элемента",
                        new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

    }*/

    //Скриншот перед закрытием браузера
    public void beforeQuit(WebDriver driver) {
        Allure.addAttachment
                ("Скриншот перед закрытием браузера",
                        new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
}

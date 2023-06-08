package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class LessonPracticeTwo {
    public static void main(String[] args) throws InterruptedException {
        //Подтягивает актуальную версию хром драйвера
        WebDriverManager.chromedriver().setup();

        //Добавляем опции в наш браузер
        ChromeOptions chromeOptions = new ChromeOptions();
        //Отключаем всплывающие окошки
        chromeOptions.addArguments("--disable-notifications");
        //Позволяет видеть сайт от лица Гугла-бота
        //chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.autodoc.ru/bot.html)");
        //Позволяет запускать код без визуального открытия браузера
        //chromeOptions.addArguments("--headless");

        //Создаём экземляр объекта webDriver и выделяем под него память, для последующего обращения к нему
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        //Открываем страницу сайта Автодок
        webDriver.get("https://www.autodoc.ru/");

        //Запускаем alert путём ввода скрипта в консоль браузера
        ((JavascriptExecutor)webDriver).executeScript
                ("let element = document.evaluate(\"//a[text()=' Популярные детали ']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");//Скрипт на удаление элемента
                //("window.alert(\"Hello world!\");");



        Thread.sleep(5000);

        //Переключаемся на alert и нажимаем на кнопку, что бы закрыть его
        //webDriver.switchTo().alert().accept();

        //Переключаемся в соседнюю вкладку
        webDriver.switchTo().newWindow(WindowType.TAB);
        //Извлекаем массив строк идентифицирующий конкретную вкладку
        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        //Указываем на какую вкладку по счёту переключится
        webDriver.switchTo().window(tabs.get(1));

        webDriver.get("https://www.ya.ru/");
        Thread.sleep(5000);
        //Закрывает текущую вкладку в браузере
        webDriver.close();

        //Прерывает выполнение кода на 5сек.
        Thread.sleep(5000);

        //Закрывает браузер полностью после выполнения кода
        webDriver.quit();
    }
}

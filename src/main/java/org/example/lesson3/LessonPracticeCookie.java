package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonPracticeCookie {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //Открыть страницу diary.ru
        driver.get("https://diary.ru/user/login");
        //Приостановить программу на 5сек.
        Thread.sleep(5000);

        //Удалить все cookie
        driver.manage().deleteAllCookies();

        //Логинимся с помощью передачи cookie. Добавить значение cookie в хедер запроса
        Cookie cookie = new Cookie("_session", "7j9161fdh58i39f4gq0aa2erbi");
        driver.manage().addCookie(cookie);
        /*
        //Получить cookie после авторизации
        Cookie cookie2 = driver.manage().getCookieNamed("_session");
        driver.manage().addCookie(cookie2);
        */

        //Обновить страницу
        driver.navigate().refresh();

        //Приостановить программу на 5сек.
        Thread.sleep(10000);

        //Закрыть браузер
        driver.quit();
    }
}

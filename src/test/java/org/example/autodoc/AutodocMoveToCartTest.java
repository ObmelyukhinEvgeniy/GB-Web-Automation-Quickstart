package org.example.autodoc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutodocMoveToCartTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Открыть страницу сайта Автодок
        driver.get("https://www.autodoc.ru/");
        //Thread.sleep(5000);
    }

    @Test
    void moveToCart() throws InterruptedException {
        //Предворительно очищаем старые cookie
        driver.manage().deleteAllCookies();

        //Создаём обьект с актуальными cookie
        Cookie cookie = new Cookie("accessToken", "eyJhbGciOiJSUzI1NiIsImtpZCI6IlNVUVNZUDhPNUtKWFlEWVVHV1paMEpJLTAtTEJUR0NGMTRCSTE2S1YiLCJ0eXAiOiJKV1QifQ.eyJzdWIiOiIxMTkyMDA1IiwibmFtZWlkIjoiMTE5MjAwNSIsInVuaXF1ZV9uYW1lIjoiU01BLTEyMSIsImVtYWlsIjoiSm8qKioqKkBtYWlsLnJ1Iiwic3RhdHVzIjoiMiIsImRpc2NvdW50Ijoi0J7Qv9GCMiIsImNpdHkiOiLQodCw0LzQsNGA0LAiLCJsYXRpdHVkZSI6IjUzMjQxNDQwIiwibG9uZ2l0dWRlIjoiNTAyMzYwOTMiLCJjdXJyZW50YWNjZXNzbGV2ZWwiOiIyIiwibmFtZSI6ItCe0LHQvCoqKiDQlSoqKiDQkioqKiIsImNpdHlpZCI6IjEwMiIsInBhcmVudGlkIjoiMTE4MzA5MyIsInBob25lIjoiKzcgKCoqKikgKioqLTMyLTE3IiwidG9rZW5fdXNhZ2UiOiJhY2Nlc3NfdG9rZW4iLCJqdGkiOiIxODZlOGUzYy0yNDNkLTRkZGQtYjcxNi0zMDZjMTQ4NGIwYjciLCJzY29wZSI6Im9mZmxpbmVfYWNjZXNzIiwibmJmIjoxNjg3NzY3NTE0LCJleHAiOjE2ODc3Njg3MTQsImlhdCI6MTY4Nzc2NzUxNCwiaXNzIjoiaHR0cHM6Ly9hdXRoLmF1dG9kb2MucnUvIn0.UQvWGivAAU3b8A-Xfldf0a5BmmEuhqD3cmmd75ys-wh9jW6n7YlZJ37P-28k7FKX9ULyTegDlAQFgubiHZl1rBs1ad_SwgtU2vof0BRUIvVU_E46gh_Mk_izTT0Jx-m8a18u5G_76TDPRH9jEXPeUYnVhcq3vf6eNcC5lw8EycX9Ne4wnfQ8mM1mEzfEw2c3m5B6wTJqDf6mzPni0CgE2BhUvCgHETARe0iJPEK4dKdt-RQbZxb-OMWZ4uyT1PIS_A_Fx77FrEDiTpTcIWg85mq6kW4RIAWPgFdZYAzuIJPjuCVAguHlhcYWx4C0qWOb2Gl2-Cgjpp3_a-WpSh40mQ");

        //Помещаем cookie в хэдер
        driver.manage().addCookie(cookie);

        //Обновить страницу
        driver.navigate().refresh();
        //Thread.sleep(3000);

        //Кликнуть ссылку "Корзина"
        driver.findElement
                (By.xpath("//a[@routerlinkactive='active-link' and @href='/cart']")).click();
        //Thread.sleep(3000);

        //Проверяем, что на странице на которую перешли появился заголовок Н1 "Корзина"
        Assertions.assertTrue
                (driver.findElement(By.xpath("//h1[text()=' Корзина ']")).isDisplayed());
        //Thread.sleep(3000);
    }
    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();

        driver.quit();
    }
}

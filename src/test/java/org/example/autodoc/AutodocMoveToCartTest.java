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
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Открыть страницу сайта Автодок
        driver.get("https://www.autodoc.ru/");
        Thread.sleep(5000);
    }

    @Test
    void moveToCart() throws InterruptedException {
        //Предворительно очищаем старые cookie
        driver.manage().deleteAllCookies();

        //Создаём обьект с актуальными cookie
        Cookie cookie = new Cookie("accessToken", "eyJhbGciOiJSUzI1NiIsImtpZCI6IlNVUVNZUDhPNUtKWFlEWVVHV1paMEpJLTAtTEJUR0NGMTRCSTE2S1YiLCJ0eXAiOiJKV1QifQ.eyJzdWIiOiIxMTkyMDA1IiwibmFtZWlkIjoiMTE5MjAwNSIsInVuaXF1ZV9uYW1lIjoiU01BLTEyMSIsImVtYWlsIjoiSm8qKioqKkBtYWlsLnJ1Iiwic3RhdHVzIjoiMiIsImRpc2NvdW50Ijoi0J7Qv9GCMiIsImNpdHkiOiLQodCw0LzQsNGA0LAiLCJsYXRpdHVkZSI6IjUzMjQxNDQwIiwibG9uZ2l0dWRlIjoiNTAyMzYwOTMiLCJjdXJyZW50YWNjZXNzbGV2ZWwiOiIyIiwibmFtZSI6ItCe0LHQvCoqKiDQlSoqKiDQkioqKiIsImNpdHlpZCI6IjEwMiIsInBhcmVudGlkIjoiMTE4MzA5MyIsInBob25lIjoiKzcgKCoqKikgKioqLTMyLTE3IiwidG9rZW5fdXNhZ2UiOiJhY2Nlc3NfdG9rZW4iLCJqdGkiOiI2NDVhYmQ4ZS1iNDFmLTQ1OTEtYjYzZS1jNzgxNmM4YjhjMDUiLCJzY29wZSI6Im9mZmxpbmVfYWNjZXNzIiwibmJmIjoxNjg3MTk5NDE1LCJleHAiOjE2ODcyMDA2MTUsImlhdCI6MTY4NzE5OTQxNSwiaXNzIjoiaHR0cHM6Ly9hdXRoLmF1dG9kb2MucnUvIn0.sBqhPjGtmnD6wYW4waxYxtjtGgGtqIzh5BxrulUnBiZ90tTC4fc9PWYSWTG6L6p_wvzNz1fuEu_PfvmxDL8qrdAMTUE8UWY-mjFmutHA_0r6piWB4ffqZWBYgieM7002_XTZ6_Zp4McxmHTJOMX3-9FgSztGWXdCrTzQbpuakuL-IORyOYtrP1LlBqBWpO7jBIfwpdFbFXM2hpS3TVTPARu1nqj_ufQZS1eL8J_E_rVZS7bxeY4gYCTcQ5jCpa1mhNLCnX_Jpn3Mpk58FTYQzNZzSW0uQrkZ4CXJg8Qagzyaes6hN43ZeB2_xike62W9qYo5VY7uWMygHnCa11Hilw");

        //Помещаем cookie в хэдер
        driver.manage().addCookie(cookie);

        //Обновить страницу
        driver.navigate().refresh();
        Thread.sleep(10000);

        //Кликнуть ссылку "Корзина"
        driver.findElement
                (By.xpath("//a[@routerlinkactive='active-link' and @href='/cart']")).click();
        Thread.sleep(3000);

        //Проверяем, что на странице на которую перешли появился заголовок Н1 "Корзина"
        Assertions.assertTrue
                (driver.findElement(By.xpath("//h1[text()=' Корзина ']")).isDisplayed());
        Thread.sleep(3000);
    }
    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();

        driver.quit();
    }
}

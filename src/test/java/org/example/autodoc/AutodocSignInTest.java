package org.example.autodoc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutodocSignInTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() throws InterruptedException {
        driver = new ChromeDriver();
        //Устанавливаем предел ожидания в 10сек.
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Неявное ожидание перед выбрасом исключения
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //Открыть страницу сайта Автодок
        driver.get("https://www.autodoc.ru/");
        //Thread.sleep(5000);


        //Установить требуемый размер окна браузера
        //driver.manage().window().setSize(new Dimension(1382, 744));
    }

    @Test
    void signIn() throws InterruptedException {
        //Кликнуть ссылку 'Личный кабинет'
        WebElement personalCabinet = driver.findElement(By.xpath("//a[contains(text(),'Личный кабинет')]"));
        personalCabinet.click();
        //Thread.sleep(3000);

        //Установить курсор в поле Логин
        WebElement loginInput = driver.findElement(By.xpath("//input[@name='Login']"));
        loginInput.click();
        //Thread.sleep(2000);

        //Ввести логин
        driver.findElement(By.xpath("//input[@id='Login']")).sendKeys("SMA-121");
        //Thread.sleep(2000);

        //Установить курсор в поле Пароль
        driver.findElement(By.xpath("//input[@name='Password']")).click();
        //Thread.sleep(2000);

        //Ввести пароль
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("A123");
        //Thread.sleep(2000);

        //Кликнуть кнопку Вход
        driver.findElement(By.xpath("//button[text()=' Вход ']")).click();
        //Thread.sleep(5000);

        //Проверяем что элемент "Логин" изменился на "SMA-121"
        Assertions.assertTrue(driver.findElement
                (By.xpath("//span[@id='user_info' and text()='SMA-121']")).isDisplayed());
        //Thread.sleep(5000);

    }

    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();

        driver.quit();
    }
}

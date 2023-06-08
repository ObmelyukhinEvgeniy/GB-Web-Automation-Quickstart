package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonPracticeCaptcha {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //Открыть страницу diary.ru
        driver.get("https://diary.ru/user/login");
        //Приостановить программу на 5сек.
        Thread.sleep(5000);

        //Установить курсор в поле Логин и ввести логин
        driver.findElement(By.xpath("//input[@id='loginform-username']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='loginform-username']")).sendKeys("spartalex");
        //Приостановить программу на 2сек.
        Thread.sleep(2000);

        //Установить курсор в поле пароль и ввести пароль
        driver.findElement(By.xpath("//input[@id='loginform-password']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='loginform-password']")).sendKeys("123456");
        //Приостановить программу на 2сек.
        Thread.sleep(2000);

        //Переключится на каптчу и включить чек-бокс "Я не робот"
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        //Приостановить программу на 10сек.
        Thread.sleep(10000);

        //Выйти из дома каптчи
        driver.switchTo().parentFrame();
        //Приостановить программу на 2сек.
        Thread.sleep(2000);

        //Нажать кнопку "Войти"
        driver.findElement(By.xpath("//button[@id='login_btn']")).click();

        //Приостановить программу на 5сек.
        Thread.sleep(5000);

        //Закрыть браузер
        driver.quit();

    }
}

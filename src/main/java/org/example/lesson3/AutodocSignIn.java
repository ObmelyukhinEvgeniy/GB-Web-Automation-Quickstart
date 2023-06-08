package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutodocSignIn {
    public static void main(String[] args) throws InterruptedException {

        //Подтянем актуальный драйвер для хрома
        WebDriverManager.chromedriver().setup();

        //Создадим объект драйвера для манипуляций с ним
        WebDriver driver = new ChromeDriver();

        //Открыть страницу сайта Автодок
        driver.get("https://www.autodoc.ru/");
        Thread.sleep(5000);

        //Установить требуемый размер окна браузера
        driver.manage().window().setSize(new Dimension(1382, 744));

        //Кликнуть ссылку 'Личный кабинет'
        WebElement personalCabinet = driver.findElement(By.xpath("//a[contains(text(),'Личный кабинет')]"));
        personalCabinet.click();
        Thread.sleep(3000);

        //Установить курсор в поле Логин
        WebElement loginInput = driver.findElement(By.xpath("//input[@name='Login']"));
        loginInput.click();
        Thread.sleep(2000);

        //Ввести логин
        driver.findElement(By.xpath("//input[@id='Login']")).sendKeys("SMA-121");
        Thread.sleep(2000);

        //Установить курсор в поле Пароль
        driver.findElement(By.xpath("//input[@name='Password']")).click();
        Thread.sleep(2000);

        //Ввести пароль
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("A123");
        Thread.sleep(2000);

        //Кликнуть кнопку Вход
        driver.findElement(By.xpath("//button[text()=' Вход ']")).click();
        Thread.sleep(5000);

        driver.quit();
    }
}

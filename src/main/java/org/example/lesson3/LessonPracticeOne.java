package org.example.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LessonPracticeOne {
    public static void main(String[] args) throws InterruptedException {

        //Подключаем вэбДрайвер к Силениуму
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Автоаналог  WebDriverManager.chromedriver().setup();

        //Создадим объект драйвера для манипуляций с ним
        WebDriver driver = new ChromeDriver();

        //Открыть страницу сайта Автодок
        driver.get("https://www.autodoc.ru/");
        Thread.sleep(5000);

        //Создаём элемент и помещаем в него xPath локатор по которому можно обратиться к нему
        WebElement login = driver.findElement(By.xpath("//a[.='Личный кабинет']"));

        //Выполняем клик по элементу
        login.click();


        //Неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Явное ожидание
        //Создаём объект который будет ожидать наш элемент 10сек
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Прописываем условия ожидания(пока не станет виден локатор элемента) и локатор элемента
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Login']")));

        Thread.sleep(5000);

        driver.quit();
    }
}

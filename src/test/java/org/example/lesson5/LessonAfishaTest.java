package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LessonAfishaTest {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.afisha.ru/");
        //Thread.sleep(5000);
    }

    @Test
    void likeMove() throws InterruptedException {
        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='КИНО']")));
        driver
                .findElement(By.xpath("//a[text()='КИНО']"))
                .click();

        //Thread.sleep(5000);
        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id='content']/div[5]/div[2]/main/section[3]/div/div[3]/div[1]/div[2]/div[1]/div[1]/a")));
        driver.findElement(By
                .xpath("//*[@id='content']/div[5]/div[2]/main/section[3]/div/div[3]/div[1]/div[2]/div[1]/div[1]/a"))
                .click();

        //Thread.sleep(5000);
        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));
        driver.findElement(By
                .xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']"))
                .click();

        //Thread.sleep(5000);
        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//iframe[contains(@src,'login-20')]")));
        driver.switchTo()
              .frame(driver.findElement(By.xpath("//iframe[contains(@src,'login-20')]")));

        Assertions.assertTrue(driver.findElement(By.xpath("//h2[text()='Вход']")).isDisplayed());
    }

    @Test
    void moveAndClickElement() throws InterruptedException {
        //Создаём объект класса Actions и передаём ему driver
        Actions actions= new Actions(driver);
        //Наводим курсор на элемент "Театр"
        actions
                .moveToElement(driver.findElement(By.xpath("//a[text()='ТЕАТР']")))//действие
                .build()//собираем цепочку объявленных выше действий
                .perform();//выполняем действия

        //Thread.sleep(5000);

        driver.findElement(By.xpath("//a[text()='Афиша театров']")).click();
        //Thread.sleep(3000);

        Assertions.assertEquals("https://www.afisha.ru/msk/schedule_theatre/", driver.getCurrentUrl());//Проверит полный URL
                //.contains("schedule_theatre"); //Проверит что URL содержит часть
    }

    @AfterEach
    void ternDown() {
        //driver.manage().deleteAllCookies();
        driver.quit();
    }

}

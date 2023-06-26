package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LessonActionsTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    Actions actions;
    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    void dragAndDrop() {
        //Открываем страницу "drag-and-drop"
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");

        //Хватаем элемент "draggable" и перетаскиваем его на элемент "droppable"
        actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable")))
                .build()
                .perform();

        //Достаём из элемента "droppable" текст и сравниваем его с "Dropped!"
        Assertions.assertEquals("Dropped!", driver.findElement(By.id("droppable")).getText());
    }

    @Test
    void demoQA() {
        driver.get("https://demoqa.com/automation-practice-form");

        //Взаимодействие с элементом "Календарь"
        driver.findElement(By.id("dateOfBirthInput")).click();
        //Создаём объект элемента select и помещаем туда элемент "Календарь"
        Select year= new Select(driver
                .findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        //Выбираем нужное значения по тексту
        year.selectByVisibleText("2003");
        //Проверяем, что в элементе year присутствует текст "2003"
        Assertions.assertEquals("2003", year.getFirstSelectedOption().getText());
    }

    @Test
    void inputFile() throws InterruptedException {
        //Взаимодействие с загрузкой файлов
        driver.get("https://demoqa.com/automation-practice-form");
        //Вкладываем файл в элемент
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\john_\\Downloads\\www.afisha.ru_.png");
        Thread.sleep(5000);
        //Assertions.assertTrue(driver.findElement(By.id("uploadPicture")).getText().contains("www.afisha.ru"));
    }

    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

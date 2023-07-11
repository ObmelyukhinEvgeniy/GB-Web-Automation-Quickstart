package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.example.lesson7.LessonAllureSteps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;
@Feature("Добавление в корзину")
public class LessonAutomationPracticeTest {
    static WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        //Дополняем ХромДрайвер действием из класса LessonAllureSteps
        driver = new EventFiringDecorator<>(new LessonAllureSteps()).decorate(new ChromeDriver());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        driver.manage().window().setSize(new Dimension(1300, 722));
    }

    @Test
    @Story("Пытаемся добавить товар в корзину")
    @Description("Это поле Description")
    void putDressToCart() throws InterruptedException {
        Thread.sleep(3000);
        //Полный вариант записи
        LessonLoginPage lessonLoginPage = new LessonLoginPage(driver);
        lessonLoginPage.login("polozhitelnyy88@mail.ru", "z123456");
        Thread.sleep(3000);
        //Сокращённый вариант записи
        new LessonMyAccountPage(driver).clickLinkTShirts();
        Thread.sleep(3000);
        new LessonTShirtsPage(driver).selectSize("S");
        Thread.sleep(3000);
        new LessonTShirtsPage(driver).selectPrice(75);
        Thread.sleep(3000);
        new LessonTShirtsPage(driver).addProductCart();
        Thread.sleep(3000);
        //new LessonBannerCart(driver).checkAssert();
        new LessonTShirtsPage(driver).checkTest();
    }

    @AfterEach
   void ternDown() {
        //Извлекаем ошибки из консоли браузера
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            Allure.addAttachment("Элемент лога браузера", logEntry.getMessage());
        }

        driver.quit();
    }

}

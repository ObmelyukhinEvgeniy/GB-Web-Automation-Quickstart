package org.example.autodoc;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Feature("Smoke test")
public class AutodocTest {
    static WebDriver driver;

    @BeforeAll
    static void driverRegister() {
        WebDriverManager.chromedriver().setup(); //Установим нужную версию хромДрайвера.
    }

    @BeforeEach
    void driverInitializing() throws InterruptedException {
        driver = new ChromeDriver(); //Инициализируе поле driver хромДрайвером
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //При ненахождении нужного элемента, driver прежде чем выкинуть исключение, будет ожидать 10сек.
        driver.manage().window().setSize(new Dimension(1300, 722)); //Устанавливаем размер окна для работы автоматизированного ПО.
        driver.get("https://www.autodoc.ru/"); //Открываем сайт Автодок
        Thread.sleep(3000); //Приостанавливаемся на 5сек.
    }

    @Test
    @Description("Выполняем вход в ЛК + Добавляем деталь в корзину")
    void signInPersonalCabinetAndAddPartToCart() throws InterruptedException {
        new AutodocLoginPage(driver).autodocSignIn("SMA-121", "A123");
        Thread.sleep(3000);
        new AutodocBuyPage(driver).addPartToCart("W671");
        Thread.sleep(3000);
        new AutodocBuyPage(driver).checkAddPart();
        Thread.sleep(3000);
    }

    @Test
    @Description("Заказываем деталь из корзины + Отменяем заказ")
    void orderPartFromCartAndRefuseOrder() throws InterruptedException {
        new AutodocLoginPage(driver).autodocSignIn("SMA-121", "A123");//Входим в ЛК
        Thread.sleep(3000);
        new AutodocCartPage(driver).orderPartFromCart();//Заказываем деталь из корзины
        Thread.sleep(3000);
        new AutodocCartPage(driver).checkOrder();//Проверяем, что появилась фраза 'Оформлен заказ на сумму...'
        Thread.sleep(3000);
        new AutodocCartPage(driver).refuseOrder();//Отказываемся от заказа
        Thread.sleep(3000);
        new AutodocCartPage(driver).checkStatusOrderRefuse();//Проверяем, что статус заказа = "Заказ снят"
    }

    @AfterEach
    void ternDown() {
        driver.quit();
    }
}

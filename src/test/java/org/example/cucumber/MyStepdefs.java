package org.example.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.lesson8.LessonLoginPage;
import org.example.lesson8.LessonMyAccountPage;
import org.example.lesson8.LessonTShirtsPage;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @io.cucumber.java.en.Given("^User Authorized$")
    public void userAuthorized() {
        open("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        new LessonLoginPage().login("polozhitelnyy88@mail.ru", "z123456");
    }

    @io.cucumber.java.en.When("^click link tshirts$")
    public void clickLinkTshirts() {
        new LessonMyAccountPage().clickLinkTShirts();
    }

    @io.cucumber.java.en.And("^select size s$")
    public void selectSizeS() {
        new LessonTShirtsPage().selectSize("S");
    }

    @io.cucumber.java.en.And("select price")
    public void selectPrice() {
        new LessonTShirtsPage().selectPrice(75);
    }

    @io.cucumber.java.en.And("^add product to cart$")
    public void addProductToCart() {
        new LessonTShirtsPage().addProductCart();
    }

    @io.cucumber.java.en.Then("^check test$")
    public void checkTest() {
        new LessonTShirtsPage().checkTest();
    }


}

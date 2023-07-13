Feature: Добавляем товар в корзину

  Background:
    Given User Authorized

  Scenario:
    When click link tshirts
    And select size s
    And select price
    And add product to cart
    Then check test

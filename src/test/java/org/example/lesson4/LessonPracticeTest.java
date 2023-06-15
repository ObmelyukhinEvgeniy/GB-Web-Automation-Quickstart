package org.example.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LessonPracticeTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод выполнится один раз перед всеми тестами.");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Метод выполнится перед каждым тестом.");
    }

    @Test
    //@Disabled //Данная аннотация отключает тест, в отчёте он виден, как отключенный
    @DisplayName("Тест проверяет сложение двух чисел.")
    void sumTest() {
        int result = LessonPracticeOne.Sum(4, 6);
        Assertions.assertEquals(10, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 4})
    @DisplayName("Параметризированный тест")
    void sumParamTest(int a) {
        int result = LessonPracticeOne.Sum(a, 6);
        Assertions.assertEquals(10, result);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Метод выполнится после каждого теста.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнится один раз после всех тестов.");
    }
}

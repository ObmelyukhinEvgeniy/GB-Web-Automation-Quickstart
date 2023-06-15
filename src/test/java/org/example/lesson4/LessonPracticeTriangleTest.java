package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LessonPracticeTriangleTest {

    @Test
    @DisplayName("Проверка корректного результата подсчёта площади")
    void valueCorrect() {
        int result = LessonPracticeTriangle.areaTriangle(20, 45, 31);
        Assertions.assertEquals(261, result);
    }
    @Test
    @DisplayName("Проверяет правило, сумма 2х сторон больше третьей.")
    void valueTwoSum() {
        int result = LessonPracticeTriangle.areaTriangle(1,1,3);
        Assertions.assertEquals(0, result);
    }

}

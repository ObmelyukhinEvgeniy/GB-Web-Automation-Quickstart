package org.example.lesson4;

public class LessonPracticeTriangle {
    public static void main(String[] args) {

    }

    static int areaTriangle(int a, int b, int c) {
        if ((a + b) < c || (b + c) < a || (c + a) < b) {
            System.out.println("Сумма двух сторон меньше третьей.Измените размеры.");
        }
        double p = (double) (a + b + c) / 2;
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return (int) S;
    }
}

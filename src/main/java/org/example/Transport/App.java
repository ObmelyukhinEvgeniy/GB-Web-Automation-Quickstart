package org.example.Transport;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassB audi = new ClassB("Audi","black", "sedan", 170, 1800, true );
        audi.isQuattro(true);
        audi.engine.setEngine(2.5, 175);
        audi.engine.getEngine();

        ClassA bmw = new ClassA("BMW","red", "coupe", 230, 1400, false);
        bmw.getConditioner();
        bmw.isQuattro(false);
        bmw.engine.setEngine(3.0, 189);
        bmw.engine.getEngine();

        ClassB honda = new ClassB("Honda","yellow", "hatchback", 180, 1350, true);
        honda.getClimateControl();
        honda.isQuattro(false);
        honda.engine.setEngine(1.8, 154);
        honda.engine.getEngine();
    }
}

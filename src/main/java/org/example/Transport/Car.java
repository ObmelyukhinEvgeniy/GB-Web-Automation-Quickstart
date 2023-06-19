package org.example.Transport;

public abstract class Car {
    private String brand;
    private String color;
    private String model;
    private int maxSpeed;
    private int weight;

    public Car(String brand, String color, String model, int maxSpeed, int weight) {
        System.out.println("\nAutomobile created.");
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        System.out.println(getValue());
    }

    public void setValue(String brand, String color, String model, int maxSpeed, int weight) {
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
    }

    public String getValue() {
        return "Brand: " + brand + "\nBody: " + model + "\nColor: " + color + "\nMax Speed: " + maxSpeed + " km/h" + "\nWeight: " + weight + " kg.";
    }

    public abstract boolean isQuattro(boolean quattro);

    static class Engine {
        private double volume;
        private int horsePower;

        public void setEngine(double volume, int horsePower) {
            this.volume = volume;
            this.horsePower = horsePower;
        }

        public void getEngine() {
            System.out.println("Объем двигателя: " + volume + " куб.\nМощность: " + horsePower + " л/с");
        }
    }

}

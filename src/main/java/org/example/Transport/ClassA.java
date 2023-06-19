package org.example.Transport;

public class ClassA extends Car{
    private boolean conditioner;
    public Engine engine = new Engine();

    public ClassA(String brand, String color, String model, int maxSpeed, int weight, boolean conditioner) {
        super(brand, color, model, maxSpeed, weight);
        this.conditioner = conditioner;
    }

    public void setValue(String brand, String color, String model, int maxSpeed, int weight, boolean conditioner) {
        super.setValue(brand, color, model, maxSpeed, weight);
        this.conditioner = conditioner;
    }

    public void getConditioner() {
        if (conditioner) {
            System.out.println("Кондиционер: установлен.");
        } else {
            System.out.println("Кондиционер: отсутствует.");
        }
    }
    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public boolean isQuattro(boolean quattro) {
        if(quattro) {
            System.out.println("Полный привод: да.");
            return true;
        } else {
            System.out.println("Полный привод: нет.");
            return false;
        }
    }


}

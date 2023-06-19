package org.example.Transport;

public class ClassB extends Car {
    private boolean climateControl;
    public Engine engine = new Engine();
    public ClassB(String brand,String color, String model, int maxSpeed, int weight, boolean climateControl) {
        super(brand, color, model, maxSpeed, weight);
        this.climateControl = climateControl;
    }

    public void setClimateControl(boolean climateControl) {
        this.climateControl = climateControl;
    }
    public void getClimateControl() {
        if (climateControl) {
            System.out.println("Climate control: установлен.");
        } else {
            System.out.println("Climate control: отсутствует.");
        }
    }

    @Override
    public boolean isQuattro(boolean quattro) {
        if (quattro) {
            System.out.println("Полный привод: да.");
            return true;
        } else {
            System.out.println("Полный привод: нет.");
            return false;
        }
    }
}

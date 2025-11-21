package src;

interface Vehicle4 {
    void start();

    void stop();

    String getInfo();

    double calculateFuelEfficiency(); // new method for Task4
}

abstract class AbstractVehicle4 implements Vehicle4 {
    protected String name;
    protected String fuel;
    protected String color;
    protected int speed;
    protected double fuelEfficiency; // store efficiency (mpg or kWh/km)

    public AbstractVehicle4(String name, String fuel, String color, double fuelEfficiency) {
        this.name = name;
        this.fuel = fuel;
        this.color = color;
        this.speed = 0;
        this.fuelEfficiency = fuelEfficiency;
    }

    public void start() {
        System.out.println(name + " is starting...");
    }

    public void stop() {
        speed = 0;
        System.out.println(name + " is stopping.");
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println(name + " accelerates by " + increment + " km/h. Current speed: " + speed);
    }

    public void decelerate(int decrement) {
        speed -= decrement;
        if (speed < 0)
            speed = 0;
        System.out.println(name + " decelerates by " + decrement + " km/h. Current speed: " + speed);
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    @Override
    public abstract String getInfo();
}

class Car4 extends AbstractVehicle4 {
    private String model;

    public Car4(String name, String model, String fuel, String color, double fuelEfficiency) {
        super(name, fuel, color, fuelEfficiency);
        this.model = model;
    }

    @Override
    public String getInfo() {
        return "Car Information:\n" +
                "Name: " + name + "\n" +
                "Model: " + model + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Fuel Efficiency: " + fuelEfficiency + " mpg\n";
    }
}

class ElectricCar4 extends AbstractVehicle4 {
    private String model;

    public ElectricCar4(String name, String model, String color, double fuelEfficiency) {
        super(name, "Electric", color, fuelEfficiency);
        this.model = model;
    }

    @Override
    public String getInfo() {
        return "Electric Car Information:\n" +
                "Name: " + name + "\n" +
                "Model: " + model + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Efficiency: " + fuelEfficiency + " kWh/km\n";
    }
}

class Bus4 extends AbstractVehicle4 {
    private int capacity;

    public Bus4(String name, String fuel, String color, int capacity, double fuelEfficiency) {
        super(name, fuel, color, fuelEfficiency);
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        return "Bus Information:\n" +
                "Name: " + name + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Capacity: " + capacity + " passengers\n" +
                "Fuel Efficiency: " + fuelEfficiency + " mpg\n";
    }
}

public class Task4 {
    public static void main(String[] args) {
        AbstractVehicle4[] vehicles = new AbstractVehicle4[3];
        vehicles[0] = new Car4("Honda Civic", "2023", "Petrol", "Red", 30.5);
        vehicles[1] = new ElectricCar4("Tesla Model 3", "2023", "White", 0.18); // kWh/km
        vehicles[2] = new Bus4("Volvo B7R", "Diesel", "Blue", 40, 12.0);

        for (AbstractVehicle4 vehicle : vehicles) {
            vehicle.start();
            vehicle.accelerate(20);
            vehicle.decelerate(10);
            vehicle.stop();
            System.out.println(vehicle.getInfo());
            System.out.println("Calculated Fuel Efficiency: " + vehicle.calculateFuelEfficiency() + "\n");
        }
    }
}

interface Vehicle3 {
    void start();

    void stop();

    String getInfo();
}

interface ElectricVehicle3 {
    void charge();
}

abstract class AbstractVehicle3 implements Vehicle3 {
    protected String name;
    protected String fuel;
    protected String color;
    protected int speed;

    public AbstractVehicle3(String name, String fuel, String color) {
        this.name = name;
        this.fuel = fuel;
        this.color = color;
        this.speed = 0;
    }

    public void start() {
        System.out.println(name + " is starting...");
    }

    public void stop() {
        speed = 0;
        System.out.println(name + " is stopping...");
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

    public abstract String getInfo();
}

class Car3 extends AbstractVehicle3 implements ElectricVehicle3 {
    private String model;

    public Car3(String name, String model, String fuel, String color) {
        super(name, fuel, color);
        this.model = model;
    }

    @Override
    public void charge() {
        System.out.println(name + ": Cannot charge. Not an electric vehicle.");
    }

    @Override
    public String getInfo() {
        return "Car Information:\n" +
                "Name: " + name + "\n" +
                "Model: " + model + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n";
    }
}

class ElectricCar3 extends AbstractVehicle3 implements ElectricVehicle3 {
    private String model;
    private int batteryLevel;

    public ElectricCar3(String name, String model, String color) {
        super(name, "Electric", color);
        this.model = model;
        this.batteryLevel = 0;
    }

    @Override
    public void charge() {
        batteryLevel = 100;
        System.out.println(name + " is charging... Battery full (" + batteryLevel + "%)");
    }

    @Override
    public String getInfo() {
        return "Electric Car Information:\n" +
                "Name: " + name + "\n" +
                "Model: " + model + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Battery Level: " + batteryLevel + "%\n";
    }
}

class ElectricMotorcycle3 extends AbstractVehicle3 implements ElectricVehicle3 {
    private String type;
    private int batteryLevel;

    public ElectricMotorcycle3(String name, String type, String color) {
        super(name, "Electric", color);
        this.type = type;
        this.batteryLevel = 0;
    }

    @Override
    public void charge() {
        batteryLevel = 100;
        System.out.println(name + " is charging... Battery full (" + batteryLevel + "%)");
    }

    @Override
    public String getInfo() {
        return "Electric Motorcycle Information:\n" +
                "Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Battery Level: " + batteryLevel + "%\n";
    }
}

public class Task3 {
    public static void main(String[] args) {
        AbstractVehicle3[] vehicles = new AbstractVehicle3[3];
        vehicles[0] = new Car3("Honda Civic", "2023", "Petrol", "Red");
        vehicles[1] = new ElectricCar3("Tesla Model 3", "2023", "White");
        vehicles[2] = new ElectricMotorcycle3("Zero SR/F", "Sport", "Black");

        for (AbstractVehicle3 vehicle : vehicles) {
            vehicle.start();
            vehicle.accelerate(30);
            vehicle.decelerate(10);

            if (vehicle instanceof ElectricVehicle3) {
                ElectricVehicle3 ev = (ElectricVehicle3) vehicle;
                ev.charge();
            }

            vehicle.stop();
            System.out.println(vehicle.getInfo());
        }
    }
}

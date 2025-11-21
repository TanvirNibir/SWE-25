interface IVehicle {
    void start();

    void stop();

    String getInfo();
}

abstract class AbstractVehicle2 implements IVehicle {
    protected String name;
    protected String fuel;
    protected String color;
    protected int speed;

    public AbstractVehicle2(String name, String fuel, String color) {
        this.name = name;
        this.fuel = fuel;
        this.color = color;
        this.speed = 0;
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println(name + " accelerates by " + increment + " km/h. Current speed: " + speed + " km/h");
    }

    public void decelerate(int decrement) {
        speed -= decrement;
        if (speed < 0)
            speed = 0;
        System.out.println(name + " decelerates by " + decrement + " km/h. Current speed: " + speed + " km/h");
    }

    @Override
    public void start() {
        System.out.println(name + " is starting...");
    }

    @Override
    public void stop() {
        speed = 0;
        System.out.println(name + " is stopping. Current speed: " + speed + " km/h");
    }

    @Override
    public abstract String getInfo();
}

class Car2 extends AbstractVehicle2 {
    private String model;

    public Car2(String name, String model, String fuel, String color) {
        super(name, fuel, color);
        this.model = model;
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

class Motorcycle2 extends AbstractVehicle2 {
    private String type;

    public Motorcycle2(String name, String type, String fuel, String color) {
        super(name, fuel, color);
        this.type = type;
    }

    @Override
    public String getInfo() {
        return "Motorcycle Information:\n" +
                "Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n";
    }
}

class Bus2 extends AbstractVehicle2 {
    private int capacity;
    private int passengers;

    public Bus2(String name, String fuel, String color, int capacity) {
        super(name, fuel, color);
        this.capacity = capacity;
        this.passengers = 0;
    }

    public void passengerEnter() {
        if (passengers < capacity) {
            passengers++;
            System.out.println("One passenger entered. Current passengers: " + passengers);
        } else {
            System.out.println("Bus is full! Cannot add more passengers.");
        }
    }

    public void passengerExit() {
        if (passengers > 0) {
            passengers--;
            System.out.println("One passenger exited. Current passengers: " + passengers);
        } else {
            System.out.println("No passengers to exit.");
        }
    }

    @Override
    public String getInfo() {
        return "Bus Information:\n" +
                "Name: " + name + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Capacity: " + capacity + "\n" +
                "Current Passengers: " + passengers + "\n";
    }
}

public class Task2 {
    public static void main(String[] args) {
        AbstractVehicle2[] vehicles = new AbstractVehicle2[3];
        vehicles[0] = new Car2("Honda Civic", "2023", "Petrol", "Red");
        vehicles[1] = new Motorcycle2("Yamaha R15", "Sport", "Gasoline", "Black");
        vehicles[2] = new Bus2("Volvo B7R", "Diesel", "Blue", 40);

        for (AbstractVehicle2 vehicle : vehicles) {
            vehicle.start();
            vehicle.accelerate(20);
            vehicle.decelerate(10);

            if (vehicle instanceof Bus2) {
                Bus2 bus = (Bus2) vehicle;
                bus.passengerEnter();
                bus.passengerEnter();
                bus.passengerExit();
            }

            vehicle.stop();
            System.out.println(vehicle.getInfo());
        }
    }
}

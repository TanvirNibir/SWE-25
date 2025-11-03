package src;

interface Vehicle {
    void start();

    void stop();

    String getInfo();
}

class ICar implements Vehicle { // class name is ICar
    private String name;
    private String fuel;
    private String color;
    private String model;

    public ICar(String name, String model, String fuel, String color) { // constructor matches class name
        this.name = name;
        this.model = model;
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println(name + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(name + " is stopping...");
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

class Motorcycle implements Vehicle {
    private String name;
    private String fuel;
    private String color;
    private String type;

    public Motorcycle(String name, String type, String fuel, String color) {
        this.name = name;
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println(name + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(name + " is stopping...");
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

class Bus implements Vehicle {
    private String name;
    private String fuel;
    private String color;
    private int capacity;

    public Bus(String name, String fuel, String color, int capacity) {
        this.name = name;
        this.fuel = fuel;
        this.color = color;
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println(name + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(name + " is stopping...");
    }

    @Override
    public String getInfo() {
        return "Bus Information:\n" +
                "Name: " + name + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Capacity: " + capacity + " passengers\n";
    }
}

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration with Names\n");

        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new ICar("Honda Civic", "2023", "Petrol", "Red");
        vehicles[1] = new Motorcycle("Yamaha R15", "Sport", "Gasoline", "Black");
        vehicles[2] = new Bus("Volvo B7R", "Diesel", "Blue", 40);

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println(vehicle.getInfo());
        }
    }
}

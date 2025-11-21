public class Calculator {
    //In a new project, write a Calculator class that has the ability to sum positive integers. A negative integer should throw an exception.
    //
    //The class acts as the model in the MVC pattern. It should have the following methods:
    //
    //A method that resets the calculator to zero.
    //A method that adds an integer to the calculator.
    //A method that returns the current value of the calculator.
    private int value;
    public Calculator() {
        this.value = 0;
    }
    public void reset() {
        this.value = 0;
    }
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        this.value += number;
    }
    public int getValue() {
        return this.value;
    }
    //make the main method to test the class
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Initial value: " + calculator.getValue());
        calculator.add(5);
        System.out.println("After adding 5: " + calculator.getValue());
        calculator.add(10);
        System.out.println("After adding 10: " + calculator.getValue());
        try {
            calculator.add(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        System.out.println("Value after attempting to add -3: " + calculator.getValue());
        calculator.reset();
        System.out.println("After reset: " + calculator.getValue());
    }
}

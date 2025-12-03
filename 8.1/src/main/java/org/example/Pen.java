package org.example;

public class Pen {

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    private Color currentColor;
    private Color drawingColor;
    private boolean isCapped;

    public Pen() {
        this.currentColor = Color.RED;
        this.drawingColor = Color.RED;
        this.isCapped = true;
    }

    public Pen(Color color) {
        this.currentColor = color;
        this.drawingColor = color;
        this.isCapped = true;
    }

    public void capOff() {
        this.isCapped = false;
        this.drawingColor = this.currentColor;
    }

    public void capOn() {
        this.isCapped = true;
    }

    public String draw() {
        if (isCapped) {
            return "";
        }
        return "Drawing " + drawingColor.toString();
    }

    public void changeColor(Color color) {
        this.currentColor = color;
    }
}

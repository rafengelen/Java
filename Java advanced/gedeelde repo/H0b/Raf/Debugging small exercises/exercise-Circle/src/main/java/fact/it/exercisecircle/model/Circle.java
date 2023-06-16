package fact.it.exercisecircle.model;

public class Circle {
    private double radius;

    public Circle() {
        radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void enlargeRadius(double amount) {
        this.radius += amount;
    }

    public double getArea() {
        double area =  Math.PI * radius * radius;
        return Math.round(area * 100.0) / 100.0;
    }

    public double getCircumference() {
        double circumference = 2 * Math.PI * radius;
        return Math.round(circumference * 100.0) / 100.0;
    }
}

package fact.it.exercisecircle.model;

public class Circle {
    double radius;

    public Circle() {
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

    public void enlargeRadius(double amount){
        this.radius += amount;
    }

    public double getCircumference() {
        return 2*radius*Math.PI;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }
}

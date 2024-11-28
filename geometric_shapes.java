import java.util.Scanner;

interface Shape {
    double area();
}
class Circle implements Shape {
    private double radius;
    private final double pi = 3.14159;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return pi * radius * radius;
    }
}
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}
class ShapeAreaCalculator {
    public void calculate_area(Shape shape) {
        System.out.println("The area of the shape is: " + shape.area());
    }
}



public class geometric_shapes {
    public static void main(String[] args) {
        Scanner jarvis = new Scanner(System.in);
        ShapeAreaCalculator calculator = new ShapeAreaCalculator();
        Shape shape = null;

        while (true) {
            System.out.println("Choose a shape to calculate the area:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            int choice = jarvis.nextInt();

            switch (choice) {
                case 1: // Circle
                    System.out.print("Enter radius of the circle: ");
                    double radius = jarvis.nextDouble();
                    shape = new Circle(radius);
                    break;

                case 2: // Rectangle
                    System.out.print("Enter length of the rectangle: ");
                    double length = jarvis.nextDouble();
                    System.out.print("Enter width of the rectangle: ");
                    double width = jarvis.nextDouble();
                    shape = new Rectangle(length, width);
                    break;

                case 3: // Triangle
                    System.out.print("Enter base of the triangle: ");
                    double base = jarvis.nextDouble();
                    System.out.print("Enter height of the triangle: ");
                    double height = jarvis.nextDouble();
                    shape = new Triangle(base, height);
                    break;

                case 4: // Exit
                    System.out.println("Exiting the program...");
                    jarvis.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }

            calculator.calculate_area(shape);
        }
    }
}

package classes;

import java.util.Scanner;

public class Coordinates {
    private float x;
    private float y;

    public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates fromInput(Scanner scanner) {
        System.out.println("Enter x:");
        float x = scanner.nextFloat();
        System.out.println("Enter y:");
        float y = scanner.nextFloat();
        return new Coordinates(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
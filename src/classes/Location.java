package classes;

import java.util.Scanner;

public class Location {
    private Float x;
    private float y;
    private String name;

    public Location(Float x, float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public static Location fromInput(Scanner scanner) {
        System.out.println("Enter x:");
        Float x = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter y:");
        float y = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        return new Location(x, y, name);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
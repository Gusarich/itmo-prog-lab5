package classes;

import interfaces.IInputOutput;

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

    public static Location fromInput(IInputOutput io) {
        System.out.println("Enter x:");
        Float x = Float.parseFloat(io.readLine());
        System.out.println("Enter y:");
        float y = Float.parseFloat(io.readLine());
        System.out.println("Enter name:");
        String name = io.readLine();
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
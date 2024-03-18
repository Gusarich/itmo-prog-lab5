package classes;

import interfaces.IInput;
import interfaces.IOutput;

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

    public static Location fromInput(IInput input, IOutput output) {
        output.println("Enter x:");
        Float x = Float.parseFloat(input.readLine());
        output.println("Enter y:");
        float y = Float.parseFloat(input.readLine());
        output.println("Enter name:");
        String name = input.readLine();
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
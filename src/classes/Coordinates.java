package classes;

import interfaces.IInputOutput;

import java.util.Scanner;

public class Coordinates {
    private float x;
    private float y;

    public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static Coordinates fromInput(IInputOutput io) {
        System.out.println("Enter x:");
        float x = Float.parseFloat(io.readLine());
        System.out.println("Enter y:");
        float y = Float.parseFloat(io.readLine());
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
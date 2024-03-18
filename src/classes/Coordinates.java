package classes;

import interfaces.IInput;
import interfaces.IOutput;

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

    public static Coordinates fromInput(IInput input, IOutput output) {
        output.println("Enter x:");
        float x = Float.parseFloat(input.readLine());
        output.println("Enter y:");
        float y = Float.parseFloat(input.readLine());
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
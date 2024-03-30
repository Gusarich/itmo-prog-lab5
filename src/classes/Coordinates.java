package classes;

import interfaces.IInput;
import interfaces.IOutput;

public record Coordinates(float x, float y) {

    public static Coordinates fromInput(IInput input, IOutput output) {
        output.print("Enter x: ");
        float x = Float.parseFloat(input.readLine());
        output.print("Enter y: ");
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
package classes;

import interfaces.IInput;
import interfaces.IOutput;

/**
 * Represents a pair of coordinates with x and y values.
 */
public record Coordinates(float x, float y) {

    /**
     * Creates a new Coordinates object from user input.
     *
     * @param input the input source
     * @param output the output destination
     * @return a new Coordinates object created from the user input
     */
    public static Coordinates fromInput(IInput input, IOutput output) {
        output.print("Enter x: ");
        float x = Float.parseFloat(input.readLine());
        if (x > 640) {
            throw new IllegalArgumentException("X must be less than or equal to 640");
        }
        output.print("Enter y: ");
        float y = Float.parseFloat(input.readLine());
        if (y > 545) {
            throw new IllegalArgumentException("Y must be less than or equal to 545");
        }
        return new Coordinates(x, y);
    }

    /**
     * Returns a string representation of the coordinates.
     *
     * @return a string representation of the coordinates
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
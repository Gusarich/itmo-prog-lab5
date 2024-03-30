package classes;

import interfaces.IInput;
import interfaces.IOutput;

import java.util.Objects;

/**
 * Represents a location with x and y coordinates and a name.
 */
public record Location(Float x, float y, String name) {

    /**
     * Creates a new Location from user input.
     *
     * @param input the input source
     * @param output the output destination
     * @return a new Location created from the user input
     */
    public static Location fromInput(IInput input, IOutput output) {
        output.print("Enter x: ");
        Float x = Float.parseFloat(input.readLine());
        output.print("Enter y: ");
        float y = Float.parseFloat(input.readLine());
        output.print("Enter name: ");
        String name = input.readLine();
        if (name.length() > 847) {
            throw new IllegalArgumentException("Name must be less than or equal to 847 characters");
        }
        return new Location(x, y, Objects.equals(name, "") ? null : name);
    }

    /**
     * Returns a string representation of the location.
     *
     * @return a string representation of the location
     */
    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
package classes;

import interfaces.IInput;
import interfaces.IOutput;

import java.util.Objects;

public record Location(Float x, float y, String name) {

    public static Location fromInput(IInput input, IOutput output) {
        output.print("Enter x: ");
        Float x = Float.parseFloat(input.readLine());
        output.print("Enter y: ");
        float y = Float.parseFloat(input.readLine());
        output.print("Enter name: ");
        String name = input.readLine();
        return new Location(x, y, Objects.equals(name, "") ? null : name);
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
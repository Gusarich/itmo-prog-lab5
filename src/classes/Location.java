package classes;

import interfaces.IInput;
import interfaces.IOutput;

public record Location(Float x, float y, String name) {

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
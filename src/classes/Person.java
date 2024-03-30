package classes;

import enums.Color;
import enums.Country;
import interfaces.IInput;
import interfaces.IOutput;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final Coordinates coordinates;
    private final LocalDateTime creationDate;
    private final int height;
    private final Color eyeColor;
    private final Color hairColor;
    private final Country nationality;
    private final Location location;

    public Person(String name, Coordinates coordinates, int height, Color eyeColor, Color hairColor, Country nationality, Location location) {
        this.id = nextId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location.toString() +
                "}";
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        result = 31 * result + coordinates.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + height;
        result = 31 * result + eyeColor.hashCode();
        result = 31 * result + hairColor.hashCode();
        result = 31 * result + nationality.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return id == other.id &&
                name.equals(other.name) &&
                coordinates.equals(other.coordinates) &&
                creationDate.equals(other.creationDate) &&
                height == other.height &&
                eyeColor == other.eyeColor &&
                hairColor == other.hairColor &&
                nationality == other.nationality &&
                location.equals(other.location);
    }

    public static Person fromInput(IInput input, IOutput output) {
        output.print("Enter name: ");
        String name = input.readLine();

        output.println("Coordinates...");
        Coordinates coordinates = Coordinates.fromInput(input, output);

        output.print("Enter height: ");
        int height = Integer.parseInt(input.readLine());

        output.print("Enter eye color: ");
        String inp = input.readLine();
        Color eyeColor = Objects.equals(inp, "") ? null : Color.valueOf(inp.toUpperCase());

        output.print("Enter hair color: ");
        Color hairColor = Color.valueOf(input.readLine().toUpperCase());

        output.print("Enter nationality: ");
        Country nationality = Country.valueOf(input.readLine().toUpperCase());

        output.println("Location...");
        Location location = Location.fromInput(input, output);

        return new Person(name, coordinates, height, eyeColor, hairColor, nationality, location);
    }

    public String toCSV() {
        return name + "," +
                coordinates.x() + "," +
                coordinates.y() + "," +
                height + "," +
                eyeColor + "," +
                hairColor + "," +
                nationality + "," +
                location.x() + "," +
                location.y() + "," +
                location.name();
    }
}
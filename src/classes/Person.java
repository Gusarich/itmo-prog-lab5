package classes;

import enums.Color;
import enums.Country;
import interfaces.IInput;
import interfaces.IOutput;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a person with various attributes.
 * Each person has a unique ID, a name, coordinates, a creation date, a height, eye color, hair color, nationality, and a location.
 */
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

    /**
     * Constructs a new Person with the given attributes.
     *
     * @param name the name of the person
     * @param coordinates the coordinates of the person
     * @param height the height of the person
     * @param eyeColor the eye color of the person
     * @param hairColor the hair color of the person
     * @param nationality the nationality of the person
     * @param location the location of the person
     */
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

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the height of the person.
     *
     * @return the height of the person
     */
    public int getHeight() {
        return height;
    }

    /**
     * Compares this person to another person based on their IDs.
     *
     * @param other the other person to compare to
     * @return a negative integer, zero, or a positive integer as this person's ID is less than, equal to, or greater than the other person's ID
     */
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.id, other.id);
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
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

    /**
     * Returns a hash code value for the person.
     *
     * @return a hash code value for the person
     */
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

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
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

    /**
     * Creates a new Person from user input.
     *
     * @param input the input source
     * @param output the output destination
     * @return a new Person created from the user input
     */
    public static Person fromInput(IInput input, IOutput output) {
        output.print("Enter name: ");
        String name = input.readLine();

        output.println("Coordinates...");
        Coordinates coordinates = Coordinates.fromInput(input, output);

        output.print("Enter height: ");
        int height = Integer.parseInt(input.readLine());
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }

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

    /**
     * Returns a CSV representation of the person.
     *
     * @return a CSV representation of the person
     */
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
package classes;

import enums.Color;
import enums.Country;
import interfaces.IInput;
import interfaces.IOutput;

import java.time.LocalDateTime;

public class Person implements Comparable<Person> {
    private static int nextId = 1;
    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private int height;
    private Color eyeColor;
    private Color hairColor;
    private Country nationality;
    private Location location;

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

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getHeight() {
        return height;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
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
        output.println("Enter name:");
        String name = input.readLine();

        output.println("Coordinates...");
        Coordinates coordinates = Coordinates.fromInput(input, output);

        output.println("Enter height:");
        int height = Integer.parseInt(input.readLine());

        output.println("Enter eye color:");
        Color eyeColor = Color.valueOf(input.readLine().toUpperCase());

        output.println("Enter hair color:");
        Color hairColor = Color.valueOf(input.readLine().toUpperCase());

        output.println("Enter nationality:");
        Country nationality = Country.valueOf(input.readLine().toUpperCase());

        output.println("Location...");
        Location location = Location.fromInput(input, output);

        return new Person(name, coordinates, height, eyeColor, hairColor, nationality, location);
    }

    public String toCSV() {
        return name + "," +
                coordinates.getX() + "," +
                coordinates.getY() + "," +
                height + "," +
                eyeColor + "," +
                hairColor + "," +
                nationality + "," +
                location.getX() + "," +
                location.getY() + "," +
                location.getName();
    }
}
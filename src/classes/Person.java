package classes;

import enums.Color;
import enums.Country;

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

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.id, other.id);
    }

    // toString, hashCode, equals methods
}
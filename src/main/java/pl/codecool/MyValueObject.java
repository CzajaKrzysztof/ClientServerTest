package pl.codecool;

import java.io.Serializable;

public class MyValueObject implements Serializable {
    private String name;
    private int value;

    public MyValueObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    public String toString() {
        return "Name: " + name + ", value: " + value;
    }
}

package net.serenitybdd.tutorials.model;

/**
 * Created by gtarrant-fisher on 02/03/2016.
 */
public class Pet {
    private String name;
    private String status;
    private int id;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                "name=" + name +
                '}';
    }

    public Pet(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

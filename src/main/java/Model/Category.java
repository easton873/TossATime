package Model;

import java.util.UUID;

public class Category {
    private UUID id;
    private String name;
    private float allotment;

    public Category(UUID id, String name, float allotment){
        this.name = name;
        this.allotment = allotment;
        this.id = id;
    }

    public Category(String name, float allotment) {
        this.name = name;
        this.allotment = allotment;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public float getAllotment() {
        return allotment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}

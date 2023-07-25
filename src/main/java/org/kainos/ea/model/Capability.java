package org.kainos.ea.model;

public class Capability {
    private int id;
    private String name;

    public Capability(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Capability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

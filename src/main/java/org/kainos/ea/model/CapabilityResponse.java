package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CapabilityResponse {
    private int id;
    private String name;

    @JsonCreator
    public CapabilityResponse(@JsonProperty("id") int id,
                              @JsonProperty("name") String name) {
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
        return "CapabilityResponse{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Band {
    private int id;
    private String bandLevel;

    @JsonCreator
    public Band(@JsonProperty("id") int id, @JsonProperty("bandLevel") String bandLevel) {
        setId(id);
        setBandLevel(bandLevel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBandLevel() {
        return bandLevel;
    }

    public void setBandLevel(String bandLevel) {
        this.bandLevel = bandLevel;
    }

    @Override
    public String toString() {
        return "Band{" + "id=" + id + ", bandLevel='" + bandLevel + '\'' + '}';
    }
}

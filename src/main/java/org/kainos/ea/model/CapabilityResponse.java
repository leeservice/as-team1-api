package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CapabilityResponse {
    private String name;

    private int capabilityId;

    @JsonCreator
    public CapabilityResponse(@JsonProperty("id") int id,
                              @JsonProperty("name") String name) {
        setCapabilityId(id);
        setName(name);
    }


    public int getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
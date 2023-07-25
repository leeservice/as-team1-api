package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleResponse {
    private int id;
    private String name;
    private String capability;

    public JobRoleResponse(@JsonProperty("id") int id,
                           @JsonProperty("name") String name,
                           @JsonProperty("capability") String capability) {
        setId(id);
        setName(name);
        setCapability(capability);
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

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    @Override
    public String toString() {
        return "JobRoleResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capability=" + capability +
                '}';
    }
}

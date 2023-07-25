package org.kainos.ea.model;

public class JobRoleRequest {
    private int id;
    private String name;
    private String capability;

    public JobRoleRequest(int id, String name, String capability) {
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
        return "JobRoleRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capability=" + capability +
                '}';
    }
}

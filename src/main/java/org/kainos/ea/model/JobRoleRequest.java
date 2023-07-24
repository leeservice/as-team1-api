package org.kainos.ea.model;

public class JobRoleRequest {
    private int id;
    private String name;
    private String specificationDesc;
    private String bandLevel;
    private int capabilityId;

    public JobRoleRequest(int id, String name, String specificationDesc, String bandLevel, int capability) {
        setId(id);
        setName(name);
        setSpecificationDesc(specificationDesc);
        setBandLevel(bandLevel);
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

    public String getSpecificationDesc() {
        return specificationDesc;
    }

    public void setSpecificationDesc(String specificationDesc) {
        this.specificationDesc = specificationDesc;
    }

    public String getBandLevel() {
        return bandLevel;
    }

    public void setBandLevel(String bandLevel) {
        this.bandLevel = bandLevel;
    }

    public int getCapability() {
        return capabilityId;
    }

    public void setCapability(int capability) {
        this.capabilityId = capability;
    }

    @Override
    public String toString() {
        return "JobRoleRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specificationDesc='" + specificationDesc + '\'' +
                ", bandLevel='" + bandLevel + '\'' +
                ", capabilityId='" + capabilityId + '\'' +
                '}';
    }
}

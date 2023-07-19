package org.kainos.ea.model;

public class JobRole {
    private int id;
    private String name;
    private String specificationDesc;
    private int bandId;

    public JobRole(int id, String name, String specificationDesc, int bandId) {
        setId(id);
        setName(name);
        setSpecificationDesc(specificationDesc);
        setBandId(bandId);
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

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getSpecificationDesc() {
        return specificationDesc;
    }

    public void setSpecificationDesc(String specificationDesc) {
        this.specificationDesc = specificationDesc;
    }

    @Override
    public String toString() {
        return "JobRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + specificationDesc + '\'' +
                ", bandId=" + bandId +
                '}';
    }
}

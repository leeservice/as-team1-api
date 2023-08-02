package org.kainos.ea.model;
public class JobRole {
    private int id;
    private String name;
    private String specificationDesc;
    private String url;

    private int bandId;

    private int capabilityId;

    public int getCapabilityId() {
        return capabilityId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCapabilityId(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    public JobRole(int id, String name, String specificationDesc, String url, int bandId, int capabilityId) {
        setId(id);
        setName(name);
        setSpecificationDesc(specificationDesc);
        setUrl(url);
        setBandId(bandId);
        setCapabilityId(capabilityId);
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
        return "JobRoleRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specificationDesc='" + specificationDesc + '\'' +
                ", url='" + url + '\'' +
                ", bandId='" + bandId + '\'' +
                ", capabilityId='" + capabilityId + '\'' +
                '}';
    }
}
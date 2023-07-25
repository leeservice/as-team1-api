package org.kainos.ea.model;

public class JobRole {
    private int id;
    private String name;
    private String specificationDesc;
    private String urlLink;

    private int bandId;

    private int capabilityId;

    public int getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    public JobRole(int id, String name, String specificationDesc, String urlLink, int bandId, int capabilityId) {
        setId(id);
        setName(name);
        setSpecificationDesc(specificationDesc);
        setUrlLink(urlLink);
        setBandId(bandId);
        setCapabilityId(capabilityId);
    }
    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
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
                ", urlLink='" + urlLink + '\'' +
                ", bandId='" + bandId + '\'' +
                ", capabilityId='" + capabilityId + '\'' +
                '}';
    }
}

package org.kainos.ea.model;

public class JobRoleRequest {
    private int id;
    private String name;
    private String specificationDesc;
    private String urlLink;
    private String bandLevel;
    private String capability;

    public JobRoleRequest(int id, String name, String specificationDesc, String urlLink, String bandLevel, String capability) {
        setId(id);
        setName(name);
        setSpecificationDesc(specificationDesc);
        setUrlLink(urlLink);
        setBandLevel(bandLevel);
        setCapability(capability);
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
                ", specificationDesc='" + specificationDesc + '\'' +
                ", url_link='" + urlLink + '\'' +
                ", bandLevel='" + bandLevel + '\'' +
                ", capability='" + capability + '\'' +
                '}';
    }
}

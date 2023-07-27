package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleResponse {
    private int id;
    private String name;
    private String specificationDesc;
    private String url;
    private String bandLevel;
    private String capability;

    @JsonCreator
    public JobRoleResponse(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("specificationDescription") String specificationDescription,
            @JsonProperty("url") String url,
            @JsonProperty("bandLevel") String bandLevel,
            @JsonProperty("capability") String capability) {
        setId(id);
        setName(name);
        setSpecificationDesc(specificationDescription);
        setUrl(url);
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
    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String urlLink) {
        this.url = urlLink;
    }


    @Override
    public String toString() {
        return "JobRoleResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specificationDesc='" + specificationDesc + '\'' +
                ", url='" + url + '\'' +
                ", bandLevel='" + bandLevel + '\'' +
                ", capability='" + capability + '\'' +
                '}';
    }
}

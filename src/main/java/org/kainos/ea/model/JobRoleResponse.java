package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleResponse {
    private int id;
    private String name;
    private String specificationDesc;
    private String URL_Link;
    private String bandLevel;
    private String capability;
    @JsonCreator
    public JobRoleResponse(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("specificationDescription") String specificationDescription,
            @JsonProperty("URL") String URL,
            @JsonProperty("capability") String capability,
            @JsonProperty("bandLevel") String bandLevel) {
        setId(id);
        setName(name);
        setSpecificationDesc(specificationDescription);
        setURL(URL);
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

    public String getURL() {
        return URL_Link;
    }

    public void setURL(String urlLink) {
        this.URL_Link = urlLink;
    }


    @Override
    public String toString() {
        return "JobRoleResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specificationDesc='" + specificationDesc + '\'' +
                ", URL='" + URL_Link + '\'' +
                ", bandLevel='" + bandLevel + '\'' +
                ", capability='" + capability + '\'' +
                '}';
    }
}

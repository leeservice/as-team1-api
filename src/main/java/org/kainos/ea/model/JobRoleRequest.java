package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleRequest {
    private String name;
    private String specificationDesc;
    private int capabilityId;
    private int bandId;
    private String url;

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

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    @Override
    public String toString() {
        return "JobRoleRequest{" +
                "name='" + name + '\'' +
                ", specificationDesc='" + specificationDesc + '\'' +
                ", capabilityId=" + capabilityId +
                ", bandId=" + bandId +
                ", url='" + url + '\'' +
                '}';
    }

    @JsonCreator
    public JobRoleRequest(@JsonProperty("name") String name,
                          @JsonProperty("specificationDesc") String specificationDesc,
                          @JsonProperty("capabilityId") int capabilityId,
                          @JsonProperty("bandId") int bandId,
                          @JsonProperty("url") String url) {
        setName(name);
        setSpecificationDesc(specificationDesc);
        setCapabilityId(capabilityId);
        setBandId(bandId);
        setUrl(url);
    }
}

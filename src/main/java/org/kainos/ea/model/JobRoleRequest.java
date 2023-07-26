package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleRequest {
    private String name;
    private String specificationDesc;
    private int capability_id;
    private int band_id;
    private String url;

    @JsonCreator
    public JobRoleRequest(@JsonProperty("name") String name, @JsonProperty("specificationDesc") String specificationDesc, @JsonProperty("capability_id") int capability_id, @JsonProperty("band_id") int band_id, @JsonProperty("url") String url) {
        setName(name);
        setName(specificationDesc);
        setCapability_id(capability_id);
        setBand_id(band_id);
        setSpecificationDesc(specificationDesc);
        setUrl(url);
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

    public int getCapability_id() {
        return capability_id;
    }

    public void setCapability_id(int capability_id) {
        this.capability_id = capability_id;
    }

    public int getBand_id() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "JobRoleRequest{" + "name='" + name + '\'' + ", specificationDesc='" + specificationDesc + '\'' + ", capability_id=" + capability_id + ", band_id=" + band_id + ", url='" + url + '\'' + '}';
    }
}

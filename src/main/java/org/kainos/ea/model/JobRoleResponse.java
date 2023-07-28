package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleResponse {
    private int id;
    private String name;
    private String capability;
    private String url;
    private String specificationDesc;
  
    @JsonCreator
    public JobRoleResponse(@JsonProperty("id") int id,
                           @JsonProperty("name") String name,
                           @JsonProperty("capability") String capability,
                           @JsonProperty("url") String url,
                           @JsonProperty("specificationDescription") String specificationDesc) {
        setId(id);
        setName(name);
        setCapability(capability);
        setSpecificationDesc(specificationDesc);
        setUrl(url);
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSpecificationDesc() {
        return specificationDesc;
    }

    public void setSpecificationDesc(String specificationDesc) {
        this.specificationDesc = specificationDesc;
    }

    @Override
    public String toString() {
        return "JobRoleResponse{" + "id=" + id + ", name='" + name + '\'' + ", capability='" + capability + '\'' + ", url='" + url + '\'' + ", specificationDescription='" + specificationDesc + '\'' + '}';
    }
}

package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleResponse {
    private int id;
    private String name;
    private String capability;
    private String urlLink;
    private String specificationDescription;

    @JsonCreator
    public JobRoleResponse(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("capability") String capability,
            @JsonProperty("urlLink") String urlLink,
            @JsonProperty("specificationDescription") String specificationDescription) {
        setId(id);
        setName(name);
        setCapability(capability);
        setSpecificationDescription(specificationDescription);
        setUrlLink(urlLink);
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

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getSpecificationDescription() {
        return specificationDescription;
    }

    public void setSpecificationDescription(String specificationDescription) {
        this.specificationDescription = specificationDescription;
    }

  @Override
  public String toString() {
    return "JobRoleResponse{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", capability='" + capability + '\'' +
        ", urlLink='" + urlLink + '\'' +
        ", specificationDescription='" + specificationDescription + '\'' +
        '}';
  }
}

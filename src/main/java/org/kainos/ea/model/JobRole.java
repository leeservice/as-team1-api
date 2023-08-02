package org.kainos.ea.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRole {
    private  int id;
    private String name;
    private String specificationDesc;
    private String url;
    private int capabilityId;
    private int bandId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
                ", url='" + url + '\'' +
                ", capabilityId=" + capabilityId +
                ", bandId=" + bandId +
                '}';
    }

    @JsonCreator
    public JobRole( @JsonProperty("id") int id,
                    @JsonProperty("name") String name,
                          @JsonProperty("specificationDesc") String specificationDesc,
                    @JsonProperty("url") String url,
                          @JsonProperty("capabilityId") int capabilityId,
                          @JsonProperty("bandId") int bandId) {
        setId(id);
        setName(name);
        setSpecificationDesc(specificationDesc);
        setUrl(url);
        setCapabilityId(capabilityId);
        setBandId(bandId);
    }

}

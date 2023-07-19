public class JobRoleRequest {
    private String name;
    private String specificationDesc;
    private String bandLevel;
    private String capability;

    public JobRoleRequest(String name, String specificationDesc, String bandLevel, String capability) {
        setName(name);
        setSpecificationDesc(specificationDesc);
        setBandLevel(bandLevel);
        setCapability(capability);
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
                "name='" + name + '\'' +
                ", specificationDesc='" + specificationDesc + '\'' +
                ", bandLevel='" + bandLevel + '\'' +
                ", capability='" + capability + '\'' +
                '}';
    }
}

public class JobRole {
    private int id;
    private String name;
    private String description;
    private int bandId;

    public JobRole(int id, String name, String description, int bandId) {
        setId(id);
        setName(name);
        setDescription(description);
        setBandId(bandId);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    @Override
    public String toString() {
        return "JobRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", bandId=" + bandId +
                '}';
    }
}

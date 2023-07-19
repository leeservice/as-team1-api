public class Band {
    private int id;
    private String level;
    private boolean trainingAvailable;
    private int competencyId;

    public Band(int id, String level, boolean trainingAvailable, int competencyId) {
        setId(id);
        setLevel(level);
        setTrainingAvailable(trainingAvailable);
        setCompetencyId(competencyId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isTrainingAvailable() {
        return trainingAvailable;
    }

    public void setTrainingAvailable(boolean trainingAvailable) {
        this.trainingAvailable = trainingAvailable;
    }

    public int getCompetencyId() {
        return competencyId;
    }

    public void setCompetencyId(int competencyId) {
        this.competencyId = competencyId;
    }
}

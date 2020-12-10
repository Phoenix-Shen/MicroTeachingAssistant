package SSM.Domain;

public class Vote_Student {
    private int VID;
    private int SID;
    private String choice;

    public int getVID() {
        return VID;
    }

    public void setVID(int VID) {
        this.VID = VID;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "Vote_Student{" +
                "VID=" + VID +
                ", SID=" + SID +
                ", choice='" + choice + '\'' +
                '}';
    }
}

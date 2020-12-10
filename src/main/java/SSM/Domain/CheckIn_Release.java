package SSM.Domain;

import java.util.Date;

public class CheckIn_Release {
    private int CID;
    private int TID;
    private String title;
    private Date StartTime;
    private Date EndTime;

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    @Override
    public String toString() {
        return "CheckIn_Release{" +
                "CID=" + CID +
                ", TID=" + TID +
                ", title='" + title + '\'' +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                '}';
    }
}

package SSM.Domain;

import java.util.Date;

public class CheckIn {
    private int CID;
    private int STUID;
    private String StuName;
    private Date CheckTime;
    private String CheckLocation;

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public int getSTUID() {
        return STUID;
    }

    public void setSTUID(int STUID) {
        this.STUID = STUID;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public Date getCheckTime() {
        return CheckTime;
    }

    public void setCheckTime(Date checkTime) {
        CheckTime = checkTime;
    }

    public String getCheckLocation() {
        return CheckLocation;
    }

    public void setCheckLocation(String checkLocation) {
        CheckLocation = checkLocation;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "CID=" + CID +
                ", STUID=" + STUID +
                ", StuName='" + StuName + '\'' +
                ", CheckTime=" + CheckTime +
                ", CheckLocation='" + CheckLocation + '\'' +
                '}';
    }
}

package SSM.Domain;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class Vote {
    private int VID;
    private int TID;
    private String Theme;
    private Date ReleaseTime;

    public int getVID() {
        return VID;
    }

    public void setVID(int VID) {
        this.VID = VID;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public Date getReleaseTime() {
        return ReleaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        ReleaseTime = releaseTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

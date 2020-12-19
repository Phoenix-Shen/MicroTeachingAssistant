package SSM.Domain;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;


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
    @JsonFormat(timezone = "GMT+8")
    public Date getStartTime() {
        return StartTime;
    }
    @JsonFormat(timezone = "GMT+8")
    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }
    @JsonFormat(timezone = "GMT+8")
    public Date getEndTime() {
        return EndTime;
    }
    @JsonFormat(timezone = "GMT+8")
    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

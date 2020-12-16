package SSM.Domain;

import com.alibaba.fastjson.JSON;

public class Vote_Student {
    private int VID;
    private String SName;
    private String choice;

    public int getVID() {
        return VID;
    }

    public void setVID(int VID) {
        this.VID = VID;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

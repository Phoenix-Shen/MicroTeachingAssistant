package SSM.Domain;

import com.alibaba.fastjson.JSON;

public class VoteOption {
    private int VID;
    private String choice;

    public int getVID() {
        return VID;
    }

    public void setVID(int VID) {
        this.VID = VID;
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
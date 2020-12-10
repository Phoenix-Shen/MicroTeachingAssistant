package SSM.Domain;

import java.util.Date;

public class Email {
    private int EID;
    private int TID;
    private String Sender;
    private Date SendTime;
    private String ETitle;

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public Date getSendTime() {
        return SendTime;
    }

    public void setSendTime(Date sendTime) {
        SendTime = sendTime;
    }

    public String getETitle() {
        return ETitle;
    }

    public void setETitle(String ETitle) {
        this.ETitle = ETitle;
    }

    @Override
    public String toString() {
        return "Email{" +
                "EID=" + EID +
                ", TID=" + TID +
                ", Sender='" + Sender + '\'' +
                ", SendTime=" + SendTime +
                ", ETitle='" + ETitle + '\'' +
                '}';
    }
}

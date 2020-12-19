package SSM.Domain;

import com.alibaba.fastjson.JSON;

public class OptionCount {


    private String choiceName;
    private Integer count;


    public OptionCount() {

    }
    public OptionCount( String choiceName,Integer count) {
        this.count = count;
        this.choiceName = choiceName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName;
    }

    @Override
    public String toString() {
       return JSON.toJSONString(this);
}
}

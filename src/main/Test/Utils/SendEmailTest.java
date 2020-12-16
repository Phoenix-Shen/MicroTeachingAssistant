package Utils;

import SSM.Domain.Email;
import SSM.Domain.Vote;
import SSM.Domain.VoteOption;
import SSM.Utils.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SendEmailTest {
    @Test
    public void sendEmail() {
        Utils.sendEmail("吃展玮肉 发送者：","我好饿","2250257231@qq.com");
    }

    @Test
    public  void run1(){
        Map<String, Object> map = new HashMap<>();
        map.put("1",new Email());
        map.put("2","这是内容");
        System.out.println(map);

    }

    @Test
    public void run2(){
        Map<String, Object> map = new HashMap<>();


        map.put("vote",new Vote());
        List<VoteOption> options= new ArrayList<>();
        VoteOption option =new VoteOption();
        option.setChoice("1111");
        option.setVID(2);
        options.add(option);
        options.add(option);
        options.add(option);
        map.put("options",options);
        System.out.println(map);
    }

}

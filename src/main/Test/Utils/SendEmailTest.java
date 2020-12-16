package Utils;

import SSM.Domain.Email;
import SSM.Utils.Utils;
import org.junit.Test;

import java.util.HashMap;
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

}

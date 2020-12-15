package Utils;

import SSM.Utils.Utils;
import org.junit.Test;


public class SendEmailTest {
    @Test
    public void sendEmail() {
        Utils.sendEmail("吃展玮肉 发送者：","我好饿","2250257231@qq.com");
    }


}

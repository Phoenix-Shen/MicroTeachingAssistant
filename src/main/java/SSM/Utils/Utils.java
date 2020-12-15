package SSM.Utils;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Utils {
    public static void sendEmail(String title,String content,String receiver){
        String sender="13593674741@163.com";
        String host ="smtp.163.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host",host);
        properties.put("mail.smtp.auth",true);
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("13593674741@163.com","NMMBLFVIEMPPJUUC");
            }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(title);
            message.setText(content);
            Transport.send(message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

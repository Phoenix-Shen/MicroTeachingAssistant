package SSM.Controller;

import SSM.Domain.Email;
import SSM.Domain.Teacher;
import SSM.Service.EmailService;
import SSM.Service.TeacherService;
import SSM.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/***
 * 学生向教师发送Email
 */
@Controller
@CrossOrigin
@RequestMapping("/Email")
public class EmailController {
    private final EmailService emailService;
    private final TeacherService teacherService;
    @Autowired
    public EmailController(EmailService emailService,TeacherService teacherService){
        this.emailService=emailService;
        this.teacherService=teacherService;
    }
    @RequestMapping("findAll")
    public @ResponseBody List<Email> findAll(){
        return emailService.findAll();
    }
    @RequestMapping("findOne")
    public @ResponseBody Email findOne(@RequestBody int EID){
        return emailService.findOne(EID);
    }
    @RequestMapping("updateEmail")
    public @ResponseBody String updateEmail(@RequestBody Email email){
        emailService.updateEmail(email);
        return "succeed";
    }
    @RequestMapping("createEmail")
    public @ResponseBody String createEmail(@RequestBody Email email){
        emailService.createEmail(email);
        return "succeed";
    }

    @RequestMapping("deleteEmail")
    public @ResponseBody String deleteEmail(@RequestBody int EID){
        emailService.deleteEmail(EID);
        return "succeed";
    }
    @RequestMapping("/findEmailByTeacher")
    @ResponseBody
    public List<Email> findEmailByTeacher(@RequestBody Integer tID){
        return emailService.findEmailByTeacher(tID);
    }

    @RequestMapping("sendEmail")
    public @ResponseBody String sendEmail(@RequestBody Map<String,Object> map) throws SQLException {
        Email email = (Email)map.get("Email");
        String context =(String)map.get("context");
        String TName =(String)map.get("TName");
        emailService.createEmail(email);
        Teacher teacher=teacherService.findOne(TName);
        Utils.sendEmail(email.getETitle(),context,teacher.getEmail());
        return "succeed";
    }
}

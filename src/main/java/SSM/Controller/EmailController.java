package SSM.Controller;

import SSM.Domain.Email;
import SSM.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Email")
public class EmailController {
    private final EmailService emailService;
    @Autowired
    public EmailController(EmailService emailService){
        this.emailService=emailService;
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
}

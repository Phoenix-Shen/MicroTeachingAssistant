package SSM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Teacher")
public class TeacherController {
@RequestMapping("/findAll")
    public String findAll(){
        System.out.println("findall方法执行");
        return "success";
    }
}

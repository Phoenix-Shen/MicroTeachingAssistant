package SSM.Controller;

import SSM.Domain.Teacher;
import SSM.Service.TeacherService;
import SSM.Utils.BadException;
import SSM.Utils.ErrPswdException;
import SSM.Utils.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptorAdapter;

import java.sql.SQLException;
import java.util.List;

/**
 * 教师管理
 */
@Controller
@CrossOrigin
@RequestMapping("/Teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService=teacherService;
    }
    @RequestMapping("/findAll")
    public @ResponseBody List<Teacher> findAll()throws SQLException{
        return teacherService.findAll();
    }
    @RequestMapping("/findOne")
    public @ResponseBody Teacher findOne(@RequestBody String name) throws SQLException, BadException {
        Teacher teacher;
        if((teacher =  teacherService.findOne(name))==null){
            throw new BadException();
        }
        else {return teacher;   }
    }

    @RequestMapping("/createTeacher")
    public @ResponseBody String createTeacher(@RequestBody Teacher teacher)throws SQLException{
        teacherService.createTeacher(teacher);
        return "succeed";
    }

    @RequestMapping("/deleteTeacher")
    public @ResponseBody String deleteTeacher(@RequestBody int ID)throws SQLException{
        teacherService.deleteTeacher(ID);
        return "succeed";
    }

    @RequestMapping("/updateTeacher")
    public @ResponseBody String updateTeacher(@RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "succeed";
    }

    @RequestMapping("/teacherLogin")
    public @ResponseBody Teacher teacherLogin(@RequestBody Teacher teacher) throws Exception {
        Teacher findResult = teacherService.findOne(teacher.getName());
        //找不到该用户
        if(findResult==null){
            throw new TeacherNotFoundException();
        }
        //用户密码对不上
        else if(findResult.getPassword().compareTo(teacher.getPassword())!=0){
            throw new ErrPswdException();
        }
        //咋呼
        else{
            findResult.setPassword(null);
            return  findResult;
        }
    }
}

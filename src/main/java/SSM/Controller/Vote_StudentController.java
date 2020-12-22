package SSM.Controller;

import SSM.Domain.OptionCount;
import SSM.Domain.Vote_Student;
import SSM.Service.Vote_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * 学生投票功能
 */
@Controller
@CrossOrigin
@RequestMapping("/Vote_Student")
public class Vote_StudentController {
    private final Vote_StudentService vote_studentService;
    @Autowired
    public Vote_StudentController(Vote_StudentService vote_studentService){
        this.vote_studentService=vote_studentService;
    }
    @RequestMapping("/findAll")
    public @ResponseBody List<Vote_Student> findAll(){
        return vote_studentService.findAll();
    }
    @RequestMapping("/findOneVoteResult")
    public @ResponseBody List<Vote_Student> findOneVoteResult(@RequestBody int VID){
        return vote_studentService.findOneVoteResult(VID);
    }
    @RequestMapping("/updateVoteOption")
    public @ResponseBody String  updateVoteOption(@RequestBody Vote_Student vote_student){
        vote_studentService.updateVoteOption(vote_student);
        return "succeed";
    }
    @RequestMapping("/createVoteOption")
    public @ResponseBody String createVoteOption(@RequestBody Vote_Student vote_student){
        vote_studentService.createVoteOption(vote_student);
        return "succeed";
    }
    @RequestMapping("/deleteVote")
    public @ResponseBody String deleteVote(@RequestBody int VID,@RequestBody String SName){
        vote_studentService.deleteVote(VID,SName);
        return "succeed";
    }
    @RequestMapping("/createVoteOptions")
    public @ResponseBody String createVoteOptions(@RequestBody List<Vote_Student>list) throws Exception {
        return vote_studentService.createVoteOptions(list);
    }

    @RequestMapping("/getOptionCounts")
    public @ResponseBody List<OptionCount> getOptionCounts(@RequestBody Integer VID){
        return vote_studentService.getOptionCounts(VID);
    }
}

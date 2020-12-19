package SSM.Controller;

import SSM.Domain.OptionCount;
import SSM.Domain.Vote_Student;
import SSM.Service.Vote_StudentService;
import SSM.Utils.BadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    @ResponseBody String createVoteOptions(@RequestBody List<Vote_Student>list) throws Exception {
        if(list.size()==0){
            //throw new org.springframework.http.converter.HttpMessageNotReadableException("ssss");
            throw new BadException();
        }
        for ( Vote_Student tmp:list ) {
            vote_studentService.createVoteOption(tmp);
        }
        return "succeed";
    }

    @RequestMapping("/getOptionCounts")
    @ResponseBody List<OptionCount> getOptionCounts(@RequestBody Integer VID){
        List<Vote_Student>vote_students=vote_studentService.findOneVoteResult(VID);
        Iterator<Vote_Student> stu_iter =vote_students.iterator();
        HashMap<String,Integer>count =new HashMap<>();
        Vote_Student tmp;
        while(stu_iter.hasNext()){
            tmp=stu_iter.next();
            if(count.containsKey(tmp.getChoice())){
                count.replace(tmp.getChoice(),count.get(tmp.getChoice())+1);
            }
            else{
                count.put(tmp.getChoice(),1);
            }
        }

        List<OptionCount>optionCountList =new ArrayList<>();

        count.forEach((key,value)->{
            OptionCount optionCountTmp=new OptionCount(key,value);
            optionCountList.add(optionCountTmp);
        });

        return optionCountList;
    }
}

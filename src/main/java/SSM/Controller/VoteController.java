package SSM.Controller;
import SSM.Domain.Vote;
import SSM.Service.VoteOptionService;
import SSM.Service.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 教师发布投票
 */
@Controller
@CrossOrigin
@RequestMapping("/Vote")
public class VoteController {
    private final VoteService voteService;
    private final VoteOptionService voteOptionService;
    @Autowired
    public VoteController(VoteService voteService,VoteOptionService voteOptionService){
        this.voteService=voteService;
        this.voteOptionService=voteOptionService;
    }

    @RequestMapping("/findAll")
    public @ResponseBody List<Vote> findAll(){
        return voteService.findAll();
    }
    @RequestMapping("/findOne")
    public @ResponseBody Vote findOne(@RequestBody Integer VID){
        return voteService.findOne(VID);
    }
    @RequestMapping("/updateVote")
    public @ResponseBody String updateVote(@RequestBody Vote vote){
        voteService.updateVote(vote);
        return "succeed";
    }
    @RequestMapping("/createVote")
    public @ResponseBody String createVote(@RequestBody Vote vote){
        voteService.createVote(vote);
        return "succeed";
    }
    @RequestMapping("/deleteVote")
    public @ResponseBody String deleteVote(@RequestBody int VID){
        voteService.deleteVote(VID);
        return "succeed";
    }
    @RequestMapping("/findVoteByTID")
    public @ResponseBody List<Vote> findVoteByTID(@RequestBody int tID){
        return voteService.findVoteByTID(tID);
    }

    @RequestMapping("/createVoteWithOptions")
    public @ResponseBody String createVoteWithOptions(@RequestBody Map<String,Object>map){
        return voteService.createVoteWithOptions(map);
    }

}

package SSM.Controller;

import SSM.Domain.Vote;
import SSM.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Vote")
public class VoteController {
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService){
        this.voteService=voteService;
    }

    @RequestMapping("/findAll")
    public @ResponseBody List<Vote> findAll(){
        return voteService.findAll();
    }
    @RequestMapping("/findAll")
    public @ResponseBody Vote findOne(@RequestBody int VID){
        return voteService.findOne(VID);
    }
    @RequestMapping("/findAll")
    public @ResponseBody String updateVote(@RequestBody Vote vote){
        voteService.updateVote(vote);
        return "succeed";
    }
    @RequestMapping("/findAll")
    public @ResponseBody String createVote(@RequestBody Vote vote){
        voteService.createVote(vote);
        return "succeed";
    }
    @RequestMapping("/findAll")
    public @ResponseBody String deleteVote(@RequestBody int VID){
        voteService.deleteVote(VID);
        return "succeed";
    }
}

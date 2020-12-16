package SSM.Controller;

import SSM.Domain.VoteOption;
import SSM.Service.VoteOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 投票的选项类
 */
@Controller
@CrossOrigin
@RequestMapping("/VoteOption")
public class VoteOptionController {

    private final VoteOptionService voteOptionService;
    @Autowired
    public VoteOptionController(VoteOptionService voteOptionService){
        this.voteOptionService=voteOptionService;
    }
    @RequestMapping("/findAll")
    public @ResponseBody List<VoteOption> findAll(){
        return voteOptionService.findAll();
    }
    @RequestMapping("/findOneVoteOptions")
    public @ResponseBody List<VoteOption> findOneVoteOptions(@RequestBody int VID){
        return voteOptionService.findOneVoteOptions(VID);
    }
    @RequestMapping("/updateVoteOption")
    public @ResponseBody String updateVoteOption(@RequestBody VoteOption voteOption,@RequestBody String choice_new){
        voteOptionService.updateVoteOption(voteOption,choice_new);
        return "succeed";
    }
    @RequestMapping("/createVoteOption")
    public @ResponseBody String createVoteOption(@RequestBody VoteOption voteoption){
        voteOptionService.createVoteOption(voteoption);
        return "succeed";
    }
    @RequestMapping("/deleteVote")
    public @ResponseBody String deleteVote(@RequestBody int VID,@RequestBody String choice){
        voteOptionService.deleteVote(VID,choice);
        return "succeed";
    }
}

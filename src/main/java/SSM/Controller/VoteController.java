package SSM.Controller;

import SSM.Domain.Vote;
import SSM.Domain.VoteOption;
import SSM.Service.VoteOptionService;
import SSM.Service.VoteService;
import com.alibaba.fastjson.JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
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
    public @ResponseBody Vote findOne(@RequestBody int VID){
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
    @ResponseBody List<Vote> findVoteByTID(@RequestBody int tID){
        return voteService.findVoteByTID(tID);
    }
    @RequestMapping("/createVoteWithOptions")
    public @ResponseBody String createVoteWithOptions(@RequestBody Map<String,Object>map){
        System.out.println(map.get("vote"));
        System.out.println(map.get("options"));
        Object o =map.get("vote");
        Object o2=map.get("options");
        ObjectMapper mapper =new ObjectMapper();
        Vote vote =mapper.convertValue(o,Vote.class);

        List<VoteOption>options =mapper.convertValue(o2,new TypeReference<List<VoteOption>>(){});
        voteService.createVote(vote);
        List<Vote>exists =voteService.findAll();
        exists.sort(Comparator.comparingInt(Vote::getVID));
        int VID_PUSH =exists.get(exists.size()-1).getVID();
        for (VoteOption option:options
             ) {
            option.setVID(VID_PUSH);
            voteOptionService.createVoteOption(option);
        }
        return "succeed";
    }

}

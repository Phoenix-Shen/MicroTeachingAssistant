package SSM.Controller;

import SSM.Domain.CheckIn;
import SSM.Service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 学生签到
 */
@Controller
@RequestMapping("/CheckIn")
public class CheckInController {

    private final CheckInService checkInService;
    @Autowired
    public CheckInController(CheckInService checkInService){
        this.checkInService=checkInService;
    }

    @RequestMapping("/findAll")
    public @ResponseBody List<CheckIn> findAll(){
        return checkInService.findAll();
    }
    @RequestMapping("/findOne")
    public @ResponseBody CheckIn findOne(@RequestBody int CID,@RequestBody int STUID){
        return checkInService.findOne(CID,STUID);
    }
    @RequestMapping("/updateCheckIn")
    public @ResponseBody String updateCheckIn(@RequestBody CheckIn checkIn){
        checkInService.updateCheckIn(checkIn);
        return "succeed";
    }
    @RequestMapping("/createCheckIn")
    public @ResponseBody String createCheckIn(@RequestBody CheckIn checkIn){
        checkInService.createCheckIn(checkIn);
        return "succeed";
    }
    @RequestMapping("/deleteCheckIn")
    public @ResponseBody String deleteCheckIn(@RequestBody int CID,@RequestBody int STUID){
        checkInService.deleteCheckIn(CID,STUID);
        return "succeed";
    }


}

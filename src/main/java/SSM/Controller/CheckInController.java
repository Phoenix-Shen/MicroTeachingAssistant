package SSM.Controller;

import SSM.Domain.CheckIn;
import SSM.Service.CheckInService;
import SSM.Service.CheckIn_ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/CheckIn")
public class CheckInController {

    private CheckInService checkInService;
    @Autowired
    public CheckInController(CheckInService checkInService){
        this.checkInService=checkInService;
    }

    @RequestMapping("/findAll")
    public @ResponseBody List<CheckIn> findAll(){
        List<CheckIn> checkInList =checkInService.findAll();
        return checkInList;
    }
    @RequestMapping("/findOne")
    public @ResponseBody CheckIn findOne(@RequestBody int CID,@RequestBody int STUID){
        CheckIn checkin = checkInService.findOne(CID,STUID);
        return checkin;
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

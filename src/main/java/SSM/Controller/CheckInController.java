package SSM.Controller;

import SSM.Domain.CheckIn;
import SSM.Domain.CheckIn_Release;
import SSM.Service.CheckInService;
import SSM.Service.CheckIn_ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

/**
 * 学生签到
 */
@Controller
@CrossOrigin
@RequestMapping("/CheckIn")
public class CheckInController {
private final CheckIn_ReleaseService checkIn_releaseService;
    private final CheckInService checkInService;
    @Autowired
    public CheckInController(CheckInService checkInService,CheckIn_ReleaseService checkIn_releaseService){
        this.checkInService=checkInService;
        this.checkIn_releaseService=checkIn_releaseService;
    }

    @RequestMapping("/findAll")
    public @ResponseBody List<CheckIn> findAll(){
        return checkInService.findAll();
    }
    @RequestMapping("/findOne")
    public @ResponseBody CheckIn findOne(@RequestBody int CID,@RequestBody int STUID){
        return checkInService.findOne(CID,STUID);
    }

    @RequestMapping("/findOneListResult")
    public @ResponseBody List<CheckIn> findOneListResult(@RequestBody Integer CID){
        return checkInService.findOneListResult(CID);
    }
    @RequestMapping("/updateCheckIn")
    public @ResponseBody String updateCheckIn(@RequestBody CheckIn checkIn){
        checkInService.updateCheckIn(checkIn);
        return "succeed";
    }
    @RequestMapping("/createCheckIn")
    public @ResponseBody String createCheckIn(@RequestBody CheckIn checkIn) throws SQLException {
        CheckIn_Release checkIn_release=checkIn_releaseService.findOne(checkIn.getCID());
        if(checkIn_release.getStartTime().compareTo(checkIn.getCheckTime())<0 &&checkIn_release.getEndTime().compareTo(checkIn.getCheckTime())>0 ){
            checkInService.createCheckIn(checkIn);
            return "succeed";
        }
        else {return "fail";}

    }
    @RequestMapping("/deleteCheckIn")
    public @ResponseBody String deleteCheckIn(@RequestBody int CID,@RequestBody int STUID){
        checkInService.deleteCheckIn(CID,STUID);
        return "succeed";
    }


}

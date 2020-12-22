package SSM.Controller;
import SSM.Domain.CheckIn_Release;
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
 * 老师发布签到
 */
@Controller
@CrossOrigin
@RequestMapping("/CheckIn_Release")
public class CheckIn_ReleaseController {

    private final CheckIn_ReleaseService checkIn_ReleaseService;
    @Autowired
    public CheckIn_ReleaseController(CheckIn_ReleaseService checkIn_releaseService) {
        this.checkIn_ReleaseService = checkIn_releaseService;
    }

    @RequestMapping("/findAll")
    public @ResponseBody List<CheckIn_Release> findAll() throws SQLException {
        return checkIn_ReleaseService.findAll();
    }

    @RequestMapping("/findOne")
    public @ResponseBody CheckIn_Release findOne( @RequestBody int CID) throws SQLException {
        return checkIn_ReleaseService.findOne(CID);
    }

    @RequestMapping("/createCheckIn_Release")
    public @ResponseBody String createCheckIn_Release(@RequestBody CheckIn_Release checkIn_release)throws SQLException{
        return  checkIn_ReleaseService.createCheckIn_Release(checkIn_release);
    }
    @RequestMapping("/deleteCheckIn_Release")
    public @ResponseBody String deleteCheckIn_Release(@RequestBody int CID)throws SQLException{
        checkIn_ReleaseService.deleteCheckIn_Release(CID);
        return "succeed";
    }
    @RequestMapping("/updateCheckIn_Release")
    public @ResponseBody String updateCheckIn_Release(@RequestBody CheckIn_Release checkInRelease){
        checkIn_ReleaseService.updateCheckIn_Release(checkInRelease);
        return "succeed";
    }
    @RequestMapping("/findCheckInByTeacher")
    public @ResponseBody List<CheckIn_Release> findCheckInByTeacher(@RequestBody int tID) throws SQLException {
        return checkIn_ReleaseService.findCheckInByTeacher(tID);
    }



}
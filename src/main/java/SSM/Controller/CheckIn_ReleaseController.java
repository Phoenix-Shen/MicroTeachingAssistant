package SSM.Controller;
import SSM.Domain.CheckIn_Release;
import SSM.Service.CheckIn_ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/CheckIn_Release")
public class CheckIn_ReleaseController {

    private CheckIn_ReleaseService checkIn_ReleaseService;
    @Autowired
    public CheckIn_ReleaseController(CheckIn_ReleaseService checkIn_releaseService) {
        this.checkIn_ReleaseService = checkIn_releaseService;
    }

    @RequestMapping("/findAll")
    public @ResponseBody List<CheckIn_Release> findAll() throws SQLException {
        List<CheckIn_Release> checkIn_Releases = checkIn_ReleaseService.findAll();
        return checkIn_Releases;
    }

    @RequestMapping("/findOne")
    public @ResponseBody CheckIn_Release findOne( @RequestBody String CID) throws SQLException {
        CheckIn_Release checkIn_Release=checkIn_ReleaseService.findOne(Integer.parseUnsignedInt(CID));
        return checkIn_Release;
    }

    @RequestMapping("/createCheckIn_Release")
    public @ResponseBody String createCheckIn_Release(@RequestBody CheckIn_Release checkInRelease)throws SQLException{
        checkIn_ReleaseService.createCheckIn_Release(checkInRelease);
        return "succeed";
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



}

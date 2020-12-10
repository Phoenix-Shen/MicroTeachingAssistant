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

    @RequestMapping("/findOne/{CID}")
    public String findOne(Model model, @PathVariable String CID) throws SQLException {
        CheckIn_Release checkIn_Release=checkIn_ReleaseService.findOne(Integer.parseUnsignedInt(CID));
        return "success";
    }




}

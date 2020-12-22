package SSM.Service.Impl;

import SSM.Dao.ICheckInDao;
import SSM.Dao.ICheckIn_ReleaseDao;
import SSM.Domain.CheckIn;
import SSM.Domain.CheckIn_Release;
import SSM.Service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service("checkInService")
public class CheckInServiceImpl implements CheckInService {
    private final ICheckInDao icheckInDao;
    private final ICheckIn_ReleaseDao iCheckIn_releaseDao;
    @Autowired
    public CheckInServiceImpl(ICheckInDao icheckInDao,ICheckIn_ReleaseDao iCheckIn_releaseDao){
        this.icheckInDao=icheckInDao;
        this.iCheckIn_releaseDao=iCheckIn_releaseDao;
    }

    @Override
    public List<CheckIn> findAll() {
        return icheckInDao.findAll();
    }

    @Override
    public List<CheckIn> findOneListResult(int CID) {
        return icheckInDao.findOneListResult(CID);
    }

    @Override
    public CheckIn findOne(int CID, int STUID) {
        return icheckInDao.findOne(CID,STUID);
    }



    @Override
    public void updateCheckIn(CheckIn checkIn) {
        icheckInDao.updateCheckIn(checkIn);
    }

    @Override
    public String createCheckIn(CheckIn checkIn) throws SQLException {
        CheckIn_Release checkIn_release=iCheckIn_releaseDao.findOne(checkIn.getCID());
        if(checkIn_release.getStartTime().compareTo(checkIn.getCheckTime())<0 &&checkIn_release.getEndTime().compareTo(checkIn.getCheckTime())>0 ){
            icheckInDao.createCheckIn(checkIn);
            return "succeed";
        }
        else {return "fail";}
    }

    @Override
    public void deleteCheckIn(int CID, int STUID) {
        icheckInDao.deleteCheckIn(CID,STUID);
    }
}

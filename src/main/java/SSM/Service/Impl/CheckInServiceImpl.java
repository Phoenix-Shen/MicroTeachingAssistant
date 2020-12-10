package SSM.Service.Impl;

import SSM.Dao.ICheckInDao;
import SSM.Domain.CheckIn;
import SSM.Service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("checkInService")
public class CheckInServiceImpl implements CheckInService {
    private ICheckInDao icheckInDao;

    @Autowired
    public CheckInServiceImpl(ICheckInDao icheckInDao){
        this.icheckInDao=icheckInDao;
    }

    @Override
    public List<CheckIn> findAll() {
        return icheckInDao.findAll();
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
    public void createCheckIn(CheckIn checkIn) {
        icheckInDao.createCheckIn(checkIn);
    }

    @Override
    public void deleteCheckIn(int CID, int STUID) {
        icheckInDao.deleteCheckIn(CID,STUID);
    }
}

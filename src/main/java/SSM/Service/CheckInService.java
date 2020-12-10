package SSM.Service;

import SSM.Domain.CheckIn;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CheckInService {
    List<CheckIn> findAll();
    CheckIn findOne(int CID, int STUID);
    void updateCheckIn(CheckIn checkIn);
    void createCheckIn(CheckIn checkIn);
    void deleteCheckIn(int CID,int STUID);
}

package SSM.Service;

import SSM.Domain.CheckIn;

import java.sql.SQLException;
import java.util.List;

public interface CheckInService {
    List<CheckIn> findAll();
    CheckIn findOne(int CID, int STUID);
    List<CheckIn>findOneListResult(int CID);
    void updateCheckIn(CheckIn checkIn);
    String createCheckIn(CheckIn checkIn) throws SQLException;
    void deleteCheckIn(int CID,int STUID);
}

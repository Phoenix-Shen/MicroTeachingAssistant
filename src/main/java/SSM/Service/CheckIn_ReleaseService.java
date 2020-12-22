package SSM.Service;

import SSM.Domain.CheckIn_Release;

import java.sql.SQLException;
import java.util.List;

public interface CheckIn_ReleaseService {
    List<CheckIn_Release> findAll()throws SQLException;
    String createCheckIn_Release(CheckIn_Release checkInRelease)throws SQLException;
    void deleteCheckIn_Release(int CID)throws SQLException;
    CheckIn_Release findOne(int CID) throws SQLException;
    void updateCheckIn_Release(CheckIn_Release checkInRelease);
    List<CheckIn_Release>findCheckInByTeacher(int tID)throws SQLException;
}

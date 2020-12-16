package SSM.Dao;

import SSM.Domain.CheckIn_Release;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/*private int CID;
    private int tID;
    private String title;
    private Date StartTime;
    private Date EndTime;*/

@Repository
public interface ICheckIn_ReleaseDao {
    @Select("Select * from checkin_release")
    List<CheckIn_Release> findAll()throws SQLException;
    @Insert("insert into checkin_release (TID,title,starttime,endtime) values(#{TID},#{title},#{StartTime},#{EndTime})")
    void createCheckIn_Release(CheckIn_Release checkInRelease)throws SQLException;
    @Delete("Delete from checkin_release where CID=#{CID}")
    void deleteCheckIn_Release(@Param("CID")int CID)throws SQLException;
    @Select("Select * from checkin_release where CID=#{CID}")
    CheckIn_Release findOne(@Param("CID")int CID) throws SQLException;
    @Update("update checkin_release set TID=#{TID} , title=#{title} , starttime=#{StartTime} , endtime=#{EndTime} where CID=#{CID}")
    void updateCheckIn_Release(CheckIn_Release checkInRelease);
    @Select("Select * from checkin_release where TID=#{TID}")
    List<CheckIn_Release>findCheckInByTeacher(@Param("TID")int tID) throws SQLException;
}

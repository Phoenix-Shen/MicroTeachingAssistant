package SSM.Dao;

import SSM.Domain.CheckIn;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*private int CID;
    private int STUID;
    private String StuName;
    private Date CheckTime;
    private String CheckLocation;*/

@Repository
public interface ICheckInDao {
    @Select("Select * from checkin")
    List<CheckIn>findAll();
    @Select("Select * from checkin where CID=#{CID} and STUID=#{STUID}")
    CheckIn findOne(@Param("CID")int CID,@Param("STUID")int STUID);
    @Update("Update checkin set stuname=#{StuName} , checktime=#{CheckTime} , checklocation=#{CheckLocation} where CID=#{CID} and STUID=#{STUID}")
    void updateCheckIn(CheckIn checkIn);
    @Insert("Insert into checkin (CID,STUID,stuname,checktime,checklocation) values(#{CID},#{STUID},#{StuName},#{CheckTime},#{CheckLocation})")
    void createCheckIn(CheckIn checkIn);
    @Delete("Delete from checkin where CID=#{CID} and STUID=#{STUID}")
    void deleteCheckIn(@Param("CID")int CID,@Param("STUID")int STUID);
}

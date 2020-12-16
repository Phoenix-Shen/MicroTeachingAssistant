package SSM.Dao;

import SSM.Domain.Vote;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/*private int VID;
    private int TID;
    private String Theme;
    private Date ReleaseTime;*/
@Repository
public interface IVoteDao {
    @Select("select * from vote")
    List<Vote> findAll();
    @Select("select * from vote where VID=#{VID}")
    Vote findOne(@Param("VID")int VID);
    @Update("update vote set TID=#{TID},theme=#{Theme},releasetime=#{ReleaseTime} where VID=#{VID}")
    void updateVote(Vote vote);
    @Insert("insert into vote (TID,theme,releasetime) values(#{TID},#{Theme},#{ReleaseTime})")
    void createVote(Vote vote);
    @Delete("delete from vote where VID=#{VID}")
    void deleteVote(@Param("VID")int VID);
    @Select("select * from vote where TID=#{TID}")
    List<Vote> findVoteByTID(@Param("TID")int TID);
}

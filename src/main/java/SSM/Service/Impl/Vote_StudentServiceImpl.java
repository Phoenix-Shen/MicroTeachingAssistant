package SSM.Service.Impl;

import SSM.Dao.IVote_StudentDao;
import SSM.Domain.OptionCount;
import SSM.Domain.Vote_Student;
import SSM.Service.Vote_StudentService;
import SSM.Utils.BadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service("vote_StudentService")
public class Vote_StudentServiceImpl implements Vote_StudentService {
    private final IVote_StudentDao iv_StudentDao;

    @Autowired
    public Vote_StudentServiceImpl(IVote_StudentDao iv_StudentDao){
        this.iv_StudentDao=iv_StudentDao;
    }

    @Override
    public List<Vote_Student> findAll() {
        return iv_StudentDao.findAll();
    }

    @Override
    public List<Vote_Student> findOneVoteResult(int VID) {
        return iv_StudentDao.findOneVoteResult(VID);
    }

    @Override
    public void updateVoteOption(Vote_Student vote_student) {
        iv_StudentDao.updateVoteOption(vote_student);
    }

    @Override
    public void createVoteOption(Vote_Student vote_student) {
        iv_StudentDao.createVoteOption(vote_student);
    }

    public String createVoteOptions( List<Vote_Student>list) throws BadException {
        if(list.size()==0){
            //throw new org.springframework.http.converter.HttpMessageNotReadableException("ssss");
            throw new BadException();
        }
        for ( Vote_Student tmp:list ) {
            iv_StudentDao.createVoteOption(tmp);
        }
        return "succeed";
    }

    @Override
    public void deleteVote(int VID, String SName) {
        iv_StudentDao.deleteVote(VID,SName);
    }

    public List<OptionCount> getOptionCounts(Integer VID){
        List<Vote_Student>vote_students=iv_StudentDao.findOneVoteResult(VID);
        Iterator<Vote_Student> stu_iter =vote_students.iterator();
        HashMap<String,Integer> count =new HashMap<>();
        Vote_Student tmp;
        while(stu_iter.hasNext()){
            tmp=stu_iter.next();
            if(count.containsKey(tmp.getChoice())){
                count.replace(tmp.getChoice(),count.get(tmp.getChoice())+1);
            }
            else{
                count.put(tmp.getChoice(),1);
            }
        }

        List<OptionCount>optionCountList =new ArrayList<>();

        count.forEach((key,value)->{
            OptionCount optionCountTmp=new OptionCount(key,value);
            optionCountList.add(optionCountTmp);
        });

        return optionCountList;
    }
}

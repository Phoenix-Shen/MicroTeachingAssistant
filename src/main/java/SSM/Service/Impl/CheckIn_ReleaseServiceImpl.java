package SSM.Service.Impl;

import SSM.Dao.ICheckIn_ReleaseDao;
import SSM.Domain.CheckIn_Release;
import SSM.Service.CheckIn_ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service("checkIn_ReleaseService")
public class CheckIn_ReleaseServiceImpl implements CheckIn_ReleaseService {
    //基于字段的注入 有一些缺点 所以不再使用 is not recommended
    /*不允许声明不可变域 容易违反单一职责设计原则 与依赖注入容器紧密耦合 隐藏依赖关系
    /*@Autowired https://zhuanlan.zhihu.com/p/92395282
    private ICheckIn_ReleaseDao iCheckIn_releaseDao;*/

    /*现在推荐使用构造函数注入 或者Setter注入*/
    private ICheckIn_ReleaseDao iCheckIn_releaseDao;

    @Autowired
    public CheckIn_ReleaseServiceImpl(ICheckIn_ReleaseDao iCheckIn_releaseDao){
        this.iCheckIn_releaseDao = iCheckIn_releaseDao;
    }


    @Override
    public List<CheckIn_Release> findAll() throws SQLException {
        return iCheckIn_releaseDao.findAll();
    }

    @Override
    public void createCheckIn_Release(CheckIn_Release checkInRelease) throws SQLException {
        iCheckIn_releaseDao.createCheckIn_Release(checkInRelease);
    }

    @Override
    public void deleteCheckIn_Release(int CID) throws SQLException {
        iCheckIn_releaseDao.deleteCheckIn_Release(CID);
    }

    @Override
    public CheckIn_Release findOne(int CID) throws SQLException {
        return iCheckIn_releaseDao.findOne(CID);
    }

    @Override
    public void updateCheckIn_Release(CheckIn_Release checkInRelease) {
        iCheckIn_releaseDao.updateCheckIn_Release(checkInRelease);
    }
}
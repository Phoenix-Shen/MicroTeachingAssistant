package SSM.Service;

import SSM.Domain.Email;
import org.apache.ibatis.annotations.Param;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmailService {
    List<Email> findAll();
    Email findOne(int EID);
    void updateEmail(Email email);
    void createEmail(Email email);
    void deleteEmail(int EID);
    List<Email> findEmailByTeacher(int tID);
    String sendEmail(Map<String, Object> map) throws SQLException;
}

package SSM.Service;

import SSM.Domain.Email;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmailService {
    List<Email> findAll();
    Email findOne(int EID);
    void updateEmail(Email email);
    void createEmail(Email email);
    void deleteCheckIn(int EID);
}

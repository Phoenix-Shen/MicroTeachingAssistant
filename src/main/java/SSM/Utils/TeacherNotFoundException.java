package SSM.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason="找不到该用户")
public class TeacherNotFoundException extends Exception {
}

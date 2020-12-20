package SSM.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST,reason="错误密码")
public class ErrPswdException extends Exception{
}

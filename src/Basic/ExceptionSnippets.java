package Basic;

import java.util.logging.Logger;

public class ExceptionSnippets {
    public static void main(String[] args) {
//        Logger logger=Logger.getGlobal();
        Logger logger = Logger.getLogger("main");
        logger.info("application started.");
        try {
            String s = "abc";
            int n = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            logger.warning(e.getMessage());
//            throw new IllegalArgumentException(e);
        } catch (Exception e) {
//            e.printStackTrace();
        }

        logger.info("application stoped.");
    }
}

class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}

class UserNotFoundException extends BaseException {

}

class LoginFailedException extends BaseException {

}

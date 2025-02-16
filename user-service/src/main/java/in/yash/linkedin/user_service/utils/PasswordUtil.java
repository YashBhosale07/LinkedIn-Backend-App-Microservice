package in.yash.linkedin.user_service.utils;

import org.mindrot.jbcrypt.BCrypt;


public class PasswordUtil {

    public static String hashPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public static boolean checkPassword(String rawPassword,String hashPassword){
        return BCrypt.checkpw(rawPassword,hashPassword);
    }

}

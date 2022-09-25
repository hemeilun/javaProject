package com.meilun.utils;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {

    /**
     * 对密码进行加密
     */
    public static String bCrypt(String password){
        String hashPw = BCrypt.hashpw(password,BCrypt.gensalt());
        return hashPw;
    }

}

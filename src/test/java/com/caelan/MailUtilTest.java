package com.caelan;

import cn.hutool.extra.mail.Mail;
import com.caelan.util.MailUtil;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MailUtilTest {

    @Test
    void send_mail2(){

            MailUtil.send_jx3("s77lpo@163.com",
                    "s77lpo@163.com");

    }

    @Test
    void hash(){
            String cacheKey;
            String username="注册注册";
            String createtime="2021-05-13 11:25:59";
            String role="jx3";
            String key=username+"@##@"+createtime+"$#%#"+role;
            try {
                final MessageDigest mDigest = MessageDigest.getInstance("MD5");
                mDigest.update(key.getBytes());
                cacheKey = bytesToHexString(mDigest.digest());
            } catch (NoSuchAlgorithmException e) {
                cacheKey = String.valueOf(key.hashCode());
            }
        System.out.println(cacheKey);

    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}

package com.caelan.util;

import lombok.SneakyThrows;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {

    @SneakyThrows
    public static void send_jx3(String code, String mail){
        String text="论坛注册地址<br>\n" +
                "<br>\n" +
                "<p>这封信是由 XXX 发送的。</p>\n" +
                "\n" +
                "<p>您收到这封邮件，是由于在 XXX 获取了新用户注册地址使用\n" +
                "了这个邮箱地址。如果您并没有访问过 XXX，或没有进行上述操作，请忽\n" +
                "略这封邮件。您不需要退订或进行其他进一步的操作。</p>\n" +
                "<br>\n" +
                "----------------------------------------------------------------------<br>\n" +
                "<strong>新用户注册说明</strong><br>\n" +
                "----------------------------------------------------------------------<br>\n" +
                "<br>\n" +
                "<p>如果您是 XXX 的新用户，或在修改您的注册 Email 时使用了本地址，我们需\n" +
                "要对您的地址有效性进行验证以避免垃圾邮件或地址被滥用。</p>\n" +
                "\n" +
                "<p>您只需点击下面的链接即可进行用户注册，以下链接有效期为3天。过期可以重新请求发送一封新的邮件验证：<br>\n" +
                "\n" +
                "<a href=\"http://121.5.211.254:8081/c-user/activatedUser/code="+code+"&email="+mail+"\" target=\"_blank\" rel=\"noopener\">" +
                "http://121.5.211.254:8081/c-user/activatedUser/code="+code+"&email="+mail+"</a>\n" +
                "<br>\n" +
                "(如果上面不是链接形式，请将该地址手工粘贴到浏览器地址栏再访问)</p>\n" +
                "\n" +
                "<p>感谢您的访问，祝您使用愉快！</p>";
        send_mailqq(mail,text);
    }
    /**
     * 使用网易邮箱发送邮件
     *
     * @param to   给谁发
     * @param text 发送内容
     */
    public static void send_mailwy(String to, String text) throws MessagingException {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器

        properties.put("mail.smtp.host", "smtp.163.com");
        //发送端口
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");

        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

//                return new javax.mail.PasswordAuthentication("你的网易邮箱", "你的网易邮箱授权码");
                return new javax.mail.PasswordAuthentication("17621831595@163.com", "cuiyanfei211");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        try {
            message.setFrom(new InternetAddress("17621831595@163.com"));
            //设置收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //设置主题
            message.setSubject("这是一份测试邮件");
            //设置邮件正文  第二个参数是邮件发送的类型
            message.setContent(text, "text/html;charset=UTF-8");
            //发送一封邮件
            Transport.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用qq邮箱发送邮件
     *
     * @param to   给谁发
     * @param text 发送内容
     */
    public static void send_mailqq(String to, String text) throws MessagingException {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器

        properties.put("mail.smtp.host", "smtp.qq.com");
        //发送端口
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");


        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new javax.mail.PasswordAuthentication("你的QQ邮箱", "你的qq邮箱授权码");
                return new javax.mail.PasswordAuthentication("1464714956@qq.com", "viaidniyabwoghee");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        try {
            message.setFrom(new InternetAddress("1464714956@qq.com"));
            //设置收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //设置主题
            message.setSubject("账号激活");
            //设置邮件正文  第二个参数是邮件发送的类型
            message.setContent(text, "text/html;charset=UTF-8");
            //发送一封邮件
            Transport.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

    }
}

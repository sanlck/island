package com.caelan.controller.Jx3;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caelan.common.lang.Result;
import com.caelan.entity.CUser;
import com.caelan.util.MD5Util;
import com.caelan.util.MailUtil;
import com.caelan.util.OtherUtils;
import lombok.SneakyThrows;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.Socket;
@RestController
@RequestMapping("/testc")
public class JavaTest {
    /**
     * 创建剑三用户
     * @param user
     * @return
     */
    @SneakyThrows
    @PostMapping(path = "/test", produces = "application/json")
    public Result addJx3(@Validated @RequestBody CUser user) {

        Socket server;
        server = new Socket("127.0.0.1", 8888);
        OutputStream out=server.getOutputStream();
        InputStream in =server.getInputStream();
            String str =user.getUsername()+"_"+user.getPassword()+"_"+user.getEmail();
        System.out.println(str);
            byte[] b=str.getBytes("GBK");
            out.write(b);
            byte[] inb=new byte[1024];
            int len = in.read(inb);
            System.out.println(new String(inb, "GBK"));

        server.close();
        return Result.succ("成功");
    }
}

package com.caelan.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caelan.common.dto.LoginDto;
import com.caelan.common.dto.updatePwddto;
import com.caelan.common.lang.Result;
import com.caelan.entity.CUser;
import com.caelan.entity.Jx3.Jx3Statements;
import com.caelan.service.CUserService;
import com.caelan.util.JwtUtils;
import com.caelan.util.MD5Util;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caelan
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/c-user")
public class CUserController {
    @Autowired
    CUserService CUserService;
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id) {
        return Result.succ(CUserService.getById(id));
    }

    @PostMapping(path = "/save", produces = "application/json")
    public Result save(@Validated @RequestBody CUser user) {
        return Result.succ(user);
    }

    @SneakyThrows
    @CrossOrigin
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        CUser user = CUserService.getOne(new QueryWrapper<CUser>().eq("username", loginDto.getUsername()));
        Assert.notNull(user, "用户不存在");
        if(!MD5Util.validPasswd(loginDto.getPassword(),user.getPassword())) {
            return Result.fail("用户名或密码错误！");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        // 用户可以另一个接口
        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }
    // 退出
    @GetMapping("/logout")
    @RequiresAuthentication
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

    /**
     * 创建剑三用户
     * @param user
     * @return
     */
    @SneakyThrows
    @PostMapping(path = "/addJx3", produces = "application/json")
    public Result addJx3(@Validated @RequestBody CUser user) {
        if((null!=user.getUsername() && user.getUsername().length()>0)
            && (null!=user.getPassword() && user.getPassword().length()>0)){
            //用户名是否存在
            List<CUser> user1=CUserService.selectByUserName(user);
            if(user1.size()>0){
                return Result.fail("用户名已存在");
            }
            //密码加密
            user.setPassword(MD5Util.getEncryptedPwd(user.getPassword().toString()));
            user.setCode(UUID.randomUUID().toString().replaceAll("-","").toLowerCase());
            user.setStatus(1);
            user.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setRole("jx3");
            int in=CUserService.insert(user);
            return Result.succ(in);
        }else{
            return Result.fail("用户名或密码不能为空");
        }

    }

    /**
     * 修改密码
     * @param updatePwddto
     * @return
     */
    @SneakyThrows
    @PostMapping(path = "/updatePwd", produces = "application/json")
    public Result updatePwd(@Validated @RequestBody updatePwddto updatePwddto) {
        CUser user = CUserService.getOne(new QueryWrapper<CUser>().eq("username", updatePwddto.getUsername()));
        if(updatePwddto.getNewpassword().equals(updatePwddto.getNew2password())){
            if(!MD5Util.validPasswd(updatePwddto.getPassword(),user.getPassword())) {
                return Result.fail("原密码错误！");
            }
            if(updatePwddto.getNewpassword().equals(updatePwddto.getPassword())){
                return Result.fail("新密码与原密码相同！");
            }
            updatePwddto.setNewpassword(MD5Util.getEncryptedPwd(updatePwddto.getNewpassword()));
            int in=CUserService.updatePwd(updatePwddto);
            return  Result.succ("更新密码成功");
        }else{
            return  Result.fail("两次输入密码不相等！");
        }

    }

    /**
     * 更新识别码
     * @param user
     * @return
     */
    @SneakyThrows
    @PostMapping(path = "/updateCode", produces = "application/json")
    public Result updateCode(@Validated @RequestBody CUser user) {
        CUser users = CUserService.getOne(new QueryWrapper<CUser>().eq("username", user.getUsername()));
        Assert.notNull(user, "用户不存在");
        if(!MD5Util.validPasswd(user.getPassword(),users.getPassword())) {
            return Result.fail("用户名或密码错误！");
        }
        CUser user2;
        String uuid="";
        do{
            uuid = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
            user2 = CUserService.getOne(new QueryWrapper<CUser>().eq("code", user.getCode()));
        }while (null!=user2);
        user.setCode(uuid);
        int in=CUserService.updateCode(user);
        return  Result.succ("更新识别码成功");

    }
}

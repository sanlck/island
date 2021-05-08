package com.caelan.controller.Jx3;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caelan.common.lang.Result;
import com.caelan.entity.CUser;
import com.caelan.entity.Jx3.*;
import com.caelan.service.CUserService;
import com.caelan.service.Jx3.Jx3GoldpriceService;
import com.caelan.service.Jx3.Jx3zhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caelan
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/jx3-zh")
public class Jx3zhController {
    @Autowired
    Jx3zhService jx3zhService;
    @Autowired
    CUserService CUserService;

    /**
     * 添加账户
     * @param jx3zh
     * @return
     */
    @PostMapping("/addZh")
    @ResponseBody
    public Result addZh(@Validated @RequestBody Jx3zh jx3zh) {
        if(null==jx3zh.getUsername() || jx3zh.getUsername().trim().length()<=0){
            return Result.fail("账号不能为空");
        }
        if(null!=jx3zh.getUsername() && jx3zh.getUsername().trim().length()>0){
            CUser cUsers=CUserService.getOne(new QueryWrapper<CUser>().eq("username",jx3zh.getUsername().trim()).eq("role","jx3"));
            if(null==cUsers || cUsers.getUsername().trim().length()<=0){
                return Result.fail("用户不存在");
            }
            jx3zh.setSavetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            boolean re=jx3zhService.save(jx3zh);
            if(re){
                return Result.succ(re);
            }else{
                return Result.fail("添加失败");
            }
        }else{
            return Result.fail("用户名不能为空");
        }

    }
    /**
     * 根据用户名查询账号(分页)
     * @param jx3zhPage
     * @return
     */
    @PostMapping("/getzh")
    @ResponseBody
    public Result GetZh(@Validated @RequestBody Jx3zhPage jx3zhPage) {
        Integer currentPage=jx3zhPage.getCurrentPage();
        if(null!=jx3zhPage.getUsername() && jx3zhPage.getUsername().trim().length()>0){
            if(currentPage == null || currentPage < 1) currentPage = 1;
            Page page = new Page(currentPage, 20);
            IPage pageData =jx3zhService.page(page,new QueryWrapper<Jx3zh>().eq("username",jx3zhPage.getUsername().trim()).orderByDesc("savetime"));
            return Result.succ(pageData);
        }else{
            return Result.fail("用户名不能为空");
        }

    }
//    List<CUser> users=cUserMapper.selectList(new QueryWrapper<CUser>().eq("username",user.getUsername().trim()));
}

package com.caelan.controller.Jx3;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caelan.common.lang.Result;
import com.caelan.entity.Jx3.Jx3Pveitem;
import com.caelan.entity.Jx3.Jx3Statements;
import com.caelan.service.Jx3.Jx3PveitemService;
import com.caelan.service.Jx3.Jx3StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 打本黑白名单 前端控制器
 * </p>
 *
 * @author caelan
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/jx3-pveitem")
public class Jx3PveitemController {
    @Autowired
    Jx3PveitemService jx3PveitemService;

    /**
     * 根据用户名查询
     * @param jx3Pveitem
     * @param currentPage
     * @return
     */
    @GetMapping("/getByName")
    @ResponseBody
    public Result getByName(@Validated @RequestBody Jx3Pveitem jx3Pveitem,Integer currentPage) {
        QueryWrapper<Jx3Pveitem> jx3PveitemWrapper=new QueryWrapper<Jx3Pveitem>();
        if(null!=jx3Pveitem.getUsername() && jx3Pveitem.getUsername().trim().length()>0){
            jx3PveitemWrapper.eq("username",jx3Pveitem.getUsername());
            if(null!=jx3Pveitem.getNametype() && jx3Pveitem.getNametype().trim().length()>0){
                jx3PveitemWrapper.eq("nametype",jx3Pveitem.getNametype());
            }
            if(null!=jx3Pveitem.getStatustype() && jx3Pveitem.getStatustype().trim().length()>0){
                jx3PveitemWrapper.eq("statustype",jx3Pveitem.getStatustype());
            }
            if(currentPage == null || currentPage < 1) currentPage = 1;
            Page page = new Page(currentPage, 20);
            IPage pageData = jx3PveitemService.page(page,jx3PveitemWrapper);
            return Result.succ(pageData);
        }else{
            return Result.fail("用户名不能为空");
        }

    }

    /**
     * 根据识别码查询
     * @param jx3Pveitem
     * @param currentPage
     * @returnCode
     */
    @GetMapping("/getByCode")
    @ResponseBody
    public Result getByCode(@Validated @RequestBody Jx3Pveitem jx3Pveitem,Integer currentPage) {
        List<Jx3Pveitem> Jx3Pveitem=new ArrayList<>();
        if(null!=jx3Pveitem.getCode() && jx3Pveitem.getCode().trim().length()>0){
            Jx3Pveitem=jx3PveitemService.getByCode(jx3Pveitem);
        }else{
            return Result.fail("识别码不能为空");
        }
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 20);

//        IPage pageData = jx3PveitemService.pageMaps(page,jx3Pveitem);
        return Result.succ(Jx3Pveitem);
    }

    @PostMapping("/add")
    public Result addPveitem(@Validated @RequestBody Jx3Pveitem jx3Pveitem){
        if(null!=jx3Pveitem.getUsername() && jx3Pveitem.getUsername().trim().length()>0){
            jx3Pveitem.setDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int in=jx3PveitemService.insert(jx3Pveitem);
            return Result.succ(in);
        }else{
            return Result.fail("用户名不能为空");
        }
    }
    @PostMapping("/edit")
    public Result editPveitem(@Validated @RequestBody Jx3Pveitem jx3Pveitem){

        if((null!=jx3Pveitem.getId() || jx3Pveitem.getId().toString().trim().length()>0) &&
                (null!=jx3Pveitem.getId() ||jx3Pveitem.getId().toString().length()>0)){
            jx3Pveitem.setDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int in=jx3PveitemService.edit(jx3Pveitem);
            return Result.succ(in);
        }else{
            return Result.fail("错误");
        }
    }

    @PostMapping("/delete/{id}")
    public Result editPveitem(@PathVariable("id") String id){

        if(null!=id ||id.length()>0){
            int in=jx3PveitemService.delete(id);
            return Result.succ(in);
        }else{
            return Result.fail("id不能为空");
        }
    }
}

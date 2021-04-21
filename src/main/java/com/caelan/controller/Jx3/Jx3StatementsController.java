package com.caelan.controller.Jx3;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caelan.common.lang.Result;
import com.caelan.entity.Jx3.Jx3Statements;
import com.caelan.mapper.Jx3.Jx3StatementsMapper;
import com.caelan.service.Jx3.Jx3StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caelan
 * @since 2021-04-08
 */
@RestController
@RequestMapping("/jx3-statements")
public class Jx3StatementsController {
    @Autowired
    Jx3StatementsService jx3StatementsService;
    @GetMapping("/gets")
    @ResponseBody
    public Result Gets(Integer currentPage) {
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 20);
        IPage pageData = jx3StatementsService.page(page, new QueryWrapper<Jx3Statements>().orderByDesc("id"));

        return Result.succ(pageData);
    }

    @PostMapping("/add")
    public Result addStatements(@Validated @RequestBody Jx3Statements jx3Statements){
        if(null!=jx3Statements.getStatemt() && jx3Statements.getStatemt().trim().length()>0){
            jx3Statements.setDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int in=jx3StatementsService.insert(jx3Statements);
            return Result.succ(in);
        }else{
            return Result.fail("信息不能为空");
        }
    }
    @PostMapping("/edit")
    public Result editStatements(@Validated @RequestBody Jx3Statements jx3Statements){

        if((null!=jx3Statements.getStatemt() || jx3Statements.getStatemt().trim().length()>0) &&
                (null!=jx3Statements.getId() ||jx3Statements.getId().toString().length()>0)){
            jx3Statements.setDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int in=jx3StatementsService.edit(jx3Statements);
            return Result.succ(in);
        }else{
            return Result.fail("主键或信息不能为空");
        }
    }

    @PostMapping("/delete/{id}")
    public Result editStatements(@PathVariable("id") String id){

        if(null!=id ||id.length()>0){
            int in=jx3StatementsService.delete(id);
            return Result.succ(in);
        }else{
            return Result.fail("id不能为空");
        }
    }
}

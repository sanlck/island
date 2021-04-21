package com.caelan.controller.Jx3;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caelan.common.lang.Result;
import com.caelan.entity.Jx3.Jx3Goldprice;
import com.caelan.entity.Jx3.Jx3Statements;
import com.caelan.service.Jx3.Jx3GoldpriceService;
import com.caelan.service.Jx3.Jx3StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 剑网三金价记录 前端控制器
 * </p>
 *
 * @author caelan
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/jx3-goldprice")
public class Jx3GoldpriceController {
    @Autowired
    Jx3GoldpriceService jx3GoldpriceService;
    @GetMapping("/gets")
    @ResponseBody
    public Result Gets(Integer currentPage) {
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 20);
        IPage pageData = jx3GoldpriceService.page(page, new QueryWrapper<Jx3Goldprice>().orderByDesc("dateTi"));
        return Result.succ(pageData);
    }

    @PostMapping("/add")
    public Result addStatements(@Validated @RequestBody Jx3Goldprice jx3Goldprice){
        if(null!=jx3Goldprice.getPrice() && jx3Goldprice.getPrice().toString().trim().length()>0){
            jx3Goldprice.setDateTi(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            int in=jx3GoldpriceService.insert(jx3Goldprice);
            return Result.succ(in);
        }else{
            return Result.fail("价格不能为空");
        }
    }
}

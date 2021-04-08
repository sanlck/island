package com.caelan.controller.Jx3;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caelan.common.lang.Result;
import com.caelan.entity.Jx3.Jx3Statements;
import com.caelan.service.Jx3.Jx3StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    public Result Gets(Integer currentPage) {
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 5);
        IPage pageData = jx3StatementsService.page(page, new QueryWrapper<Jx3Statements>().orderByDesc("id"));
        return Result.succ(pageData);
    }
}

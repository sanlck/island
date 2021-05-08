package com.caelan.controller.Jx3;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caelan.common.lang.Result;
import com.caelan.entity.Jx3.Jx3Statements;
import com.caelan.entity.Jx3.Jx3czjl;
import com.caelan.entity.Jx3.Jx3zh;
import com.caelan.service.Jx3.Jx3czjlService;
import com.caelan.service.Jx3.Jx3zhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 剑网三充值记录 前端控制器
 * </p>
 *
 * @author caelan
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/jx3-czjl")
public class Jx3czjlController {
    @Autowired
    Jx3czjlService jx3czjlService;
    @Autowired
    Jx3zhService jx3zhService;

    /**
     * 冲销记录查询
     * @param currentPage
     * @return
     */
    @GetMapping("/gets")
    @ResponseBody
    public Result Gets(Integer currentPage) {
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 20);
        IPage pageData = jx3czjlService.page(page, new QueryWrapper<Jx3czjl>().orderByDesc("ordertime"));
        return Result.succ(pageData);
    }
    /**
     * 添加充值记录
     * @param jx3czjl
     * @return
     */
    @PostMapping("addczjl")
    @ResponseBody
    public Result addczjl(@Validated @RequestBody Jx3czjl jx3czjl){
        Jx3zh jx3zh=jx3zhService.getOne(new QueryWrapper<Jx3zh>().eq("zhname", jx3czjl.getZh()));
        if(null==jx3zh){
            return Result.fail("账号不存在");
        }
        boolean re=jx3czjlService.save(jx3czjl);
        if(re){
            return Result.succ(re);
        }else{
            return Result.fail("添加失败");
        }
    }
}

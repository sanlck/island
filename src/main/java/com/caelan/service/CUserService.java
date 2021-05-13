package com.caelan.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caelan.common.dto.updatePwddto;
import com.caelan.entity.CUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caelan.entity.Jx3.Jx3Statements;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caelan
 * @since 2021-04-07
 */
public interface CUserService extends IService<CUser> {

    int insert(CUser user);

    List<CUser> selectByUserName(CUser user);

    int updatePwd(updatePwddto updatePwddto);

    int updateCode(CUser user);

    int activate(CUser cuser);
}

package com.caelan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caelan.common.dto.updatePwddto;
import com.caelan.entity.CUser;
import com.caelan.mapper.CUserMapper;
import com.caelan.service.CUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caelan
 * @since 2021-04-07
 */
@Service
public class CUserServiceImpl extends ServiceImpl<CUserMapper, CUser> implements CUserService {

    @Autowired
    CUserMapper cUserMapper;
    @Override
    public int insert(CUser user) {
        int in=cUserMapper.insert(user);
        return in;
    }

    @Override
    public List<CUser> selectByUserName(CUser user) {
        List<CUser> users=cUserMapper.selectList(new QueryWrapper<CUser>().eq("username",user.getUsername().trim()));
        return users;
    }

    @Override
    public int updatePwd(updatePwddto updatePwddto) {
        int in =cUserMapper.updatePwd(updatePwddto);
        return in;
    }

    @Override
    public int updateCode(CUser user) {
        int in =cUserMapper.updateCode(user);
        return in;
    }


}




















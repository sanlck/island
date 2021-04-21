package com.caelan.service.impl.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        cUserMapper.insert(user);
        return 0;
    }

    @Override
    public List<CUser> selectByUserName(CUser user) {
        List<CUser> users=cUserMapper.selectList(new QueryWrapper<CUser>().select("username",user.getUsername().trim()));
        return users;
    }


}




















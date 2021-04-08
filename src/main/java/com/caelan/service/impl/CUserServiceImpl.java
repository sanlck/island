package com.caelan.service.impl;

import com.caelan.entity.CUser;
import com.caelan.mapper.CUserMapper;
import com.caelan.service.CUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}

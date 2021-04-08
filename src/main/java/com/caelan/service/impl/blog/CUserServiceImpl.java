package com.caelan.service.impl.blog;

import com.caelan.entity.blog.CUser;
import com.caelan.mapper.blog.CUserMapper;
import com.caelan.service.blog.CUserService;
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

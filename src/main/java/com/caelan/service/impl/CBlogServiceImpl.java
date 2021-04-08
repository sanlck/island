package com.caelan.service.impl;

import com.caelan.entity.CBlog;
import com.caelan.mapper.CBlogMapper;
import com.caelan.service.CBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caelan
 * @since 2021-04-08
 */
@Service
public class CBlogServiceImpl extends ServiceImpl<CBlogMapper, CBlog> implements CBlogService {

}

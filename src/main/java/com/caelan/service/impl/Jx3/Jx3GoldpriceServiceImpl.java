package com.caelan.service.impl.Jx3;

import com.caelan.entity.Jx3.Jx3Goldprice;
import com.caelan.mapper.Jx3.Jx3GoldpriceMapper;
import com.caelan.mapper.Jx3.Jx3StatementsMapper;
import com.caelan.service.Jx3.Jx3GoldpriceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 剑网三金价记录 服务实现类
 * </p>
 *
 * @author caelan
 * @since 2021-04-19
 */
@Service
public class Jx3GoldpriceServiceImpl extends ServiceImpl<Jx3GoldpriceMapper, Jx3Goldprice> implements Jx3GoldpriceService {

    @Autowired
    Jx3GoldpriceMapper jx3GoldpriceMapper;
    @Override
    public int insert(Jx3Goldprice jx3Goldprice) {
        int in=jx3GoldpriceMapper.insert(jx3Goldprice);
        return in;
    }
}

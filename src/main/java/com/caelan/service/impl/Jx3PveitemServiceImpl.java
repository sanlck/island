package com.caelan.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.caelan.entity.Jx3.Jx3Pveitem;
import com.caelan.mapper.Jx3.Jx3PveitemMapper;
import com.caelan.service.Jx3.Jx3PveitemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 打本黑白名单 服务实现类
 * </p>
 *
 * @author caelan
 * @since 2021-04-21
 */
@Service
public class Jx3PveitemServiceImpl extends ServiceImpl<Jx3PveitemMapper, Jx3Pveitem> implements Jx3PveitemService {

    @Autowired
    Jx3PveitemMapper jx3PveitemMapper;
    @Override
    public int insert(Jx3Pveitem jx3Pveitem) {
        int in=jx3PveitemMapper.insert(jx3Pveitem);
        return 0;
    }

    @Override
    public int edit(Jx3Pveitem jx3Pveitem) {
        int in=jx3PveitemMapper.updatepve(jx3Pveitem);
        return in;
    }

    @Override
    public int delete(String id) {
        int in=jx3PveitemMapper.deleteById(id);
        return 0;
    }

    @Override
    public List<Jx3Pveitem> getByCode(Jx3Pveitem jx3Pveitem) {
        List<Jx3Pveitem> jx3PveitemWrapper=jx3PveitemMapper.getByCode(jx3Pveitem);
        return jx3PveitemWrapper;
    }
}

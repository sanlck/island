package com.caelan.service.impl.Jx3;

import com.caelan.entity.Jx3.Jx3Statements;
import com.caelan.mapper.Jx3.Jx3StatementsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caelan.service.Jx3.Jx3StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Jx3StatementsServiceImpl extends ServiceImpl<Jx3StatementsMapper, Jx3Statements> implements Jx3StatementsService {
    @Autowired
    Jx3StatementsMapper Jx3StatementsMapper;
    public int insert(Jx3Statements jx3Statements){
        int in=Jx3StatementsMapper.insert(jx3Statements);
        return in;
    }

    @Override
    public int edit(Jx3Statements jx3Statements) {
        int in= Jx3StatementsMapper.updateById(jx3Statements);
        return in;
    }

    @Override
    public int delete(String id) {
        int in= Jx3StatementsMapper.deleteById(id);
        return in;
    }
}

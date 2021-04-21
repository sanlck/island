package com.caelan.service.Jx3;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.caelan.entity.Jx3.Jx3Statements;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caelan.mapper.Jx3.Jx3StatementsMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caelan
 * @since 2021-04-08
 */
public interface Jx3StatementsService extends IService<Jx3Statements> {
    public int insert(Jx3Statements jx3Statements);
    public int edit(Jx3Statements jx3Statements);
    public int delete(String id);
}

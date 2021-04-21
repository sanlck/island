package com.caelan.service.Jx3;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.caelan.entity.Jx3.Jx3Pveitem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 打本黑白名单 服务类
 * </p>
 *
 * @author caelan
 * @since 2021-04-21
 */
public interface Jx3PveitemService extends IService<Jx3Pveitem> {

    int insert(Jx3Pveitem jx3Pveitem);

    int edit(Jx3Pveitem jx3Pveitem);

    int delete(String id);

    Wrapper<Jx3Pveitem> getByCode(Jx3Pveitem jx3Pveitem);
}

package com.caelan.mapper.Jx3;

import com.caelan.entity.Jx3.Jx3Pveitem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 打本黑白名单 Mapper 接口
 * </p>
 *
 * @author caelan
 * @since 2021-04-21
 */
public interface Jx3PveitemMapper extends BaseMapper<Jx3Pveitem> {

    int updatepve(Jx3Pveitem jx3Pveitem);

    List<Jx3Pveitem> getByCode(Jx3Pveitem jx3Pveitem);
}

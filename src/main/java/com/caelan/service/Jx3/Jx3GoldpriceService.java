package com.caelan.service.Jx3;

import com.caelan.entity.Jx3.Jx3Goldprice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 剑网三金价记录 服务类
 * </p>
 *
 * @author caelan
 * @since 2021-04-19
 */
public interface Jx3GoldpriceService extends IService<Jx3Goldprice> {

    int insert(Jx3Goldprice jx3Goldprice);
}

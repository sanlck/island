package com.caelan.entity.Jx3;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 剑网三充值记录
 * </p>
 *
 * @author caelan
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Jx3czjl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableId("orderNo")
    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String zh;

    /**
     * 订单时间
     */
    @NotBlank(message = "订单时间不能为空")
    private String ordertime;

    /**
     * 金额
     */
    @NotBlank(message = "金额不能为空")
    private String amt;


}

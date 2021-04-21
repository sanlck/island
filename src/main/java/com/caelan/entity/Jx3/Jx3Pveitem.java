package com.caelan.entity.Jx3;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 打本黑白名单
 * </p>
 *
 * @author caelan
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Jx3Pveitem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String code;

    private String name;

    private String nametype;

    private String statustype;

    private String reason;

    private String datetime;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


}

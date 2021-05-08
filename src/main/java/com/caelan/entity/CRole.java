package com.caelan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author caelan
 * @since 2021-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableField("roleId")
    private String roleId;

    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;

    /**
     * 角色类别
     */
    @TableField("roleType")
    private String roleType;


}

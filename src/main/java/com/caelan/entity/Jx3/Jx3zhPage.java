package com.caelan.entity.Jx3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author caelan
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Jx3zhPage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String zhname;

    private String username;
    private String savetime;
    Integer currentPage;


}

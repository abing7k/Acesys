package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hanbing
 * @since 2022-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("menu_role")
@ApiModel(value="MenuRole对象", description="")
public class MenuRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer rid;

    private Integer mid;


}

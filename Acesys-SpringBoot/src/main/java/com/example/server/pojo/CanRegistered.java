package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("can_registered")
@ApiModel(value="CanRegistered对象", description="")
public class CanRegistered implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "能否注册,1代表能, 0代表不能")
    private Integer registered;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}

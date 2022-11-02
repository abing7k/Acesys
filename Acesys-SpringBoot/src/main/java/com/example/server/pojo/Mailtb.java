package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Mailtb对象", description="")
public class Mailtb implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表示邮件ID，是自动递增的主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "表示发邮件地址")
    private String fromaddress;

    @ApiModelProperty(value = "表示发邮件密码")
    private String frompassword;

    @ApiModelProperty(value = "表示收邮件地址")
    private String toaddress;


}

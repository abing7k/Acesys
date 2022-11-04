package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

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
@ApiModel(value="Orders对象", description="")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表示订单ID，是自动递增的主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "表示客户标识号")
    private Integer uid;

    @ApiModelProperty(value = "表示生成订单的时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/ShangHai")
    private LocalDate datetime;

    @ApiModelProperty(value = "1代表删除,0代表未删除")
    @TableField("del_flag")
    @TableLogic
    private Integer delFlag;


}

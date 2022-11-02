package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value="Product对象", description="")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表示商品ID标识号，是自动递增的主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "表示药品类别")
    private String category;

    @ApiModelProperty(value = "表示备注")
    private String note;

    @ApiModelProperty(value = "表示商品编号")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty(value = "表示药品名称")
    private String productname;

    @ApiModelProperty(value = "1表示删除,0表示未删除")
    @TableLogic
    @TableField("del_flag")
    private Boolean delFlag;

    @ApiModelProperty(value = "表示分子结构图片路径名称")
    private String image;

    @ApiModelProperty(value = "表示是否是新产品")
    private Integer newproduct;

    @ApiModelProperty(value = "表示普通用户价格")
    private String price1;

    @ApiModelProperty(value = "表示会员优惠价格")
    private String price2;

    @ApiModelProperty(value = "表示实际库存")
    private String realstock;

    @ApiModelProperty(value = "表示库存")
    private String stock;

    @ApiModelProperty(value = "表示化学文摘登记号 ")
    private String cas;

    @ApiModelProperty(value = "表示药品类别")
    private String catalogno;

    @ApiModelProperty(value = "表示药品分类")
    private String mdlint;

    @ApiModelProperty(value = "表示化学方程式")
    private String formula;

    @ApiModelProperty(value = "重量")
    private String weight;


}

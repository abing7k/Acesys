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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
@ApiModel(value="Usr对象", description="")
public class Usr implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表示用户ID标识号，是自动递增的主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "表示用户名称")
    private String username;

    @ApiModelProperty(value = "表示用户密码(加密后)")
    private String password;

    @ApiModelProperty(value = "表示用户公司名称")
    private String companyname;

    @ApiModelProperty(value = "表示用户生活城市")
    private String city;

    @ApiModelProperty(value = "表示用户工作")
    private String job;

    @ApiModelProperty(value = "表示用户电话")
    private String tel;

    @ApiModelProperty(value = "表示用户电子邮件地址")
    private String email;

    @ApiModelProperty(value = "表示用户国家")
    private String country;

    @ApiModelProperty(value = "表示地区邮政编码")
    private String zip;

    @ApiModelProperty(value = "表示用户公司地址")
    private String companyaddress;

    @ApiModelProperty(value = "表示备注")
    private String note;

    @ApiModelProperty(value = "表示全名")
    private String fullname;

    @ApiModelProperty(value = "表示称呼")
    private String title;

    @ApiModelProperty(value = "1代表删除, 0代表未删除")
    @TableField("del_flag")
    @TableLogic
    private Integer delFlag;

    @ApiModelProperty(value = "角色")
    @TableField(exist = false)
    private String roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roleList = new ArrayList();
        Role role = new Role();
        role.setNameZh(roles);
        roleList.add(role);
        List<SimpleGrantedAuthority> authorities = roleList
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getNameZh()))
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

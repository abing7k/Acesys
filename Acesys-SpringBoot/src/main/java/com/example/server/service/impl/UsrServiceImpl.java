package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.config.security.component.JwtTokenUtils;
import com.example.server.mapper.CanRegisteredMapper;
import com.example.server.mapper.RoleMapper;
import com.example.server.mapper.UserRoleMapper;
import com.example.server.mapper.UsrMapper;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Role;
import com.example.server.pojo.UserRole;
import com.example.server.pojo.Usr;
import com.example.server.service.IUsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
@Service
public class UsrServiceImpl extends ServiceImpl<UsrMapper, Usr> implements IUsrService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UsrMapper usrMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private CanRegisteredMapper canRegisteredMapper;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StringUtils.isEmpty(code) || !captcha.equalsIgnoreCase(code)) {
            return RespBean.error("验证码出入错误,请重新驶入");
        }
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号被禁用,请联系管理员");
        }

        //更新Security用户登录对象
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //生成token
        String token = jwtTokenUtils.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登录成功", tokenMap);
    }

    @Override
    public Usr getUsrByUserName(String username) {
        return usrMapper.selectOne(new QueryWrapper<Usr>()
                .eq("username", username));
    }

    @Override
    public String getRolesById(Integer id) {
        return roleMapper.getRolesById(id);
    }

    @Override
    @Transactional
    public RespBean addUsr(Usr usr) {
        if (!usr.getPassword().isEmpty()) {
            usr.setPassword(passwordEncoder.encode(usr.getPassword()));
        }
        String roles = usr.getRoles();
        int m = usrMapper.insert(usr);
        int n = 0;
        if (roles != null && !roles.equals("")) {
            UserRole userRole = new UserRole();
            userRole.setUid(usr.getId());
            if (roles.equals("管理员")) {
                userRole.setRid(1);
                System.out.println(userRole);
                n = n + userRoleMapper.insert(userRole);
            }
            if (roles.equals("会员")) {
                userRole.setRid(1);
                n = n + userRoleMapper.insert(userRole);
            }
        }
        if (m + n >= 2) {
            return RespBean.success("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @Override
    @Transactional
    public RespBean updateUsr(Usr usr) {
        System.out.println(usr);
        if (usr.getPassword() != null && usr.getPassword().length() > 0) {
            usr.setPassword(passwordEncoder.encode(usr.getPassword()));
        }else {
            usr.setPassword(usrMapper.getPasswordById(usr.getId()));
        }
        String roles = usr.getRoles();
        int m = usrMapper.updateById(usr);
        if (roles != null && !roles.equals("")) {
            UserRole userRole = new UserRole();
            userRole.setUid(usr.getId());
            if (roles.equals("管理员")) {
                userRole.setRid(1);
                System.out.println(userRole);
                userRoleMapper.updateById(userRole);
            }
            if (roles.equals("会员")) {
                userRole.setRid(1);
                userRoleMapper.updateById(userRole);
            }
        }
        if (m > 0) {
            return RespBean.success("修改成功");
        } else {
            return RespBean.error("修改失败");
        }
    }

    @Override
    @Transactional
    public RespBean deleteUsr(Integer id) {
        if (usrMapper.deleteById(id) + userRoleMapper.updateByUid(id) >= 2) {
            return RespBean.success("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }

    @Override
    public RespBean showUsrs() {
        return RespBean.success("查询成功", usrMapper.selectAll());
    }

    @Override
    public RespBean registered(Usr usr) {
        if (canRegisteredMapper.selectById(1).getRegistered() == 1) {
            if (!usr.getPassword().isEmpty()) {
                usr.setPassword(passwordEncoder.encode(usr.getPassword()));
            } else {
                return RespBean.error("密码不能为空");
            }
            String roles = usr.getRoles();
            int m = usrMapper.insert(usr);
            int n = 0;
            if (roles != null && !roles.equals("")) {
                UserRole userRole = new UserRole();
                userRole.setUid(usr.getId());
                if (roles.equals("管理员")) {
                    return RespBean.error("不能注册管理员");
                }
                if (roles.equals("会员")) {
                    userRole.setRid(1);
                    n = n + userRoleMapper.insert(userRole);
                }
            }
            if (m + n >= 2) {
                return RespBean.success("添加成功");
            } else {
                return RespBean.error("添加失败");
            }
        } else {
            return RespBean.error("注册功能未开放");
        }
    }

}

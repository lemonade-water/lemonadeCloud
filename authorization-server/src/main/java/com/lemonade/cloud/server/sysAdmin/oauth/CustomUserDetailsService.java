package com.lemonade.cloud.server.sysAdmin.oauth;

import com.lemonade.cloud.common.entity.model.sysAdmin.SysRole;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import com.lemonade.cloud.common.enums.sysAdmin.SysUserEnum;
import com.lemonade.cloud.server.sysAdmin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username:{}",username);
        SysUser user = userService.getSysUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("用户账号或密码错误");
        }
        String status = user.getStatus();
        /*可用*/
        boolean enable = status.equals(SysUserEnum.ENABLE.getCode());
        /*禁用*/
        boolean locked = status.equals(SysUserEnum.DISABLE.getCode());
        /*冻结*/
        boolean frozen = status.equals(SysUserEnum.FROZEN.getCode());
        Set<SysRole> roles = user.getRoles();
        if (roles.isEmpty()){

        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                enable,
                !locked,
                !frozen,
                !locked,
                roles.stream().map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toSet()));
    }
}

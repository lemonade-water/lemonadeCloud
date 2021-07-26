package com.lemonade.cloud.server.sysAdmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUserRole;
import com.lemonade.cloud.server.sysAdmin.mapper.SysUserMapper;
import com.lemonade.cloud.server.sysAdmin.service.SysRoleService;
import com.lemonade.cloud.server.sysAdmin.service.SysUserRoleService;
import com.lemonade.cloud.server.sysAdmin.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysUserRoleService sysUserRoleService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public SysUser getUserByUsername(String username){
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,username);
        SysUser user = sysUserMapper.selectOne(wrapper);
        if (user!=null){
            Set<String> roles = sysRoleService.getRolesByUserId(user.getId());
            if (roles!=null && !roles.isEmpty()){
                user.setRoles(new HashSet<>(sysRoleService.listByIds(roles)));
            }
        }
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(SysUser user, List<String> roleIds) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        sysUserMapper.insert(user);
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        for(String roleId:roleIds){
            SysUserRole userRole = new SysUserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(user.getId());
            sysUserRoles.add(userRole);
        }
        return sysUserRoleService.saveBatch(sysUserRoles);
    }
}

package com.lemonade.cloud.server.sysAdmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUserRole;
import com.lemonade.cloud.server.sysAdmin.mapper.SysUserRoleMapper;
import com.lemonade.cloud.server.sysAdmin.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper,SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
}

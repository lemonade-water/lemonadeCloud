package com.lemonade.cloud.server.sysAdmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysRole;

import java.util.Set;

public interface SysRoleService extends IService<SysRole> {
    Set<String> getRolesByUserId(String id);
}

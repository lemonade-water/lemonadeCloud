package com.lemonade.cloud.server.sysAdmin.service;

import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import org.springframework.cache.annotation.Cacheable;

public interface UserService {

    @Cacheable(value = "#id")
    SysUser getSysUserByUsername(String username);
}

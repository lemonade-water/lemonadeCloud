package com.lemonade.cloud.server.sysAdmin.provider.fallback;

import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import com.lemonade.cloud.common.entity.vo.Result;
import com.lemonade.cloud.server.sysAdmin.provider.SysUserProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SysUserProviderFallback implements SysUserProvider {

    @Override
    public Result<SysUser> getSysUserByUsername(String username) {
        log.error("获取用户失败！");
        return Result.success(new SysUser());
    }
}

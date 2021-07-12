package com.lemonade.cloud.server.sysAdmin.provider;

import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import com.lemonade.cloud.common.entity.vo.Result;
import com.lemonade.cloud.server.sysAdmin.provider.fallback.SysUserProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sysAdmin",fallback = SysUserProviderFallback.class)
public interface SysUserProvider {


    @GetMapping(value = "/sysUser/getUserByUsername")
    Result<SysUser> getSysUserByUsername(@RequestParam("username") String username);

}

package com.lemonade.cloud.common.enums.sysAdmin;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SysUserEnum {

    ENABLE("1","正常"),
    FROZEN("2","冻结"),
    DISABLE("3","禁用"),

    ;
    private String code;

    private String name;

}

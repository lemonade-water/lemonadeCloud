package com.lemonade.cloud.common.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("添加用户表单")
public class SysUserDto implements Serializable {
    @ApiModelProperty(value = "name",name = "姓名")
    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 20, message = "用户名长度在3到20个字符")
    private String name;

    @ApiModelProperty(value = "mobile",name = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "username",name = "姓名")
    @Length(min = 3, max = 20, message = "姓名长度在3到20个字符")
    @NotBlank(message = "姓名不能为空")
    private String username;

    @ApiModelProperty(value = "password",name = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "description",name = "描述")
    private String description;

    @ApiModelProperty(value = "roleIds",name = "角色ids")
    @NotEmpty(message = "角色不能为空")
    private List<String> roleIds;
}

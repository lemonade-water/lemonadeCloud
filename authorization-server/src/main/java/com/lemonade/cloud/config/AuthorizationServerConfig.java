package com.lemonade.cloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 授权服务配置
 */
@Configuration
//@EnableAuthorizationServer 当前pom的oauth2版本已过时
@EnableWebSecurity
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    //ClientDetailsServiceConfigurer：通过配置的数据源，配置ClientDetailsService
    //AuthorizationServerSecurityConfigurer：用来配置令牌端点(Token Endpoint)的安全约束.
    //AuthorizationServerEndpointsConfigurer：用来配置授权（authorization）以及令牌（token）

    //将客户端信息存储在mysql中、token数据存储在redis中

}

DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id                      VARCHAR(20) PRIMARY KEY COMMENT '用户id',
    username                VARCHAR(100) NOT NULL COMMENT '用户名',
    password                VARCHAR(100) NOT NULL COMMENT '用户密码密文',
    name                    VARCHAR(200) COMMENT '用户姓名',
    mobile                  VARCHAR(20) COMMENT '用户手机',
    description             VARCHAR(500) COMMENT '简介',
    deleted                 VARCHAR(1)   NOT NULL DEFAULT '0' COMMENT '是否已删除1：已删除，0：未删除',
    status                  VARCHAR(1) COMMENT '用户状态',
    created_time            DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time            DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_user              VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_user              VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '用户表';
CREATE UNIQUE INDEX ux_users_username
    ON sys_user (username);
CREATE UNIQUE INDEX ux_users_mobile
    ON sys_user (mobile);

--  角色表
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id           VARCHAR(20) PRIMARY KEY COMMENT '角色id',
    code         VARCHAR(100) NOT NULL COMMENT '角色code',
    name         VARCHAR(200) COMMENT '角色名称',
    description  VARCHAR(500) COMMENT '简介',
    created_time DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_user   VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_user   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '角色表';

-- 用户和角色关系表
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
    id           VARCHAR(20) PRIMARY KEY COMMENT '关系id',
    user_id      VARCHAR(20)  NOT NULL COMMENT '用户id',
    role_id      VARCHAR(20)  NOT NULL COMMENT '角色id',
    created_time DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_user   VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_user   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '用户和角色关系表';
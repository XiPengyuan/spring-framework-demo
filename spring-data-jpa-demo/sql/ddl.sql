-- 创建MySQL示例表
CREATE TABLE tb_user (
    id        BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    user_num  CHAR(6) NOT NULL UNIQUE COMMENT '编号',
    name      VARCHAR(30) COMMENT '姓名',
    age       INT COMMENT '年龄',
    grade     INT COMMENT '年级',
    email     VARCHAR(50) COMMENT '邮箱',
    residence BIGINT COMMENT '居住地'
) COMMENT = '用户表';

CREATE TABLE tb_address (
    id       BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    province VARCHAR(8)  NOT NULL COMMENT '省份',
    city     VARCHAR(8)  NOT NULL COMMENT '市',
    district VARCHAR(16) NOT NULL COMMENT '区'
) COMMENT = '地址表';

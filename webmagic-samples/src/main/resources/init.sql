create database IF NOT EXISTS mango517;

use mango517;

CREATE TABLE IF NOT EXISTS ershoufang (
    house_code INT NOT NULL COMMENT '房源编码 七位数字 3133014' ,
    title VARCHAR(255) NOT NULL COMMENT '标题',
    `location` VARCHAR(255) NOT NULL COMMENT '地址',
    `desc` TEXT COMMENT '描述',
    price VARCHAR(255) NOT NULL COMMENT '总价',
    house_type VARCHAR(255) NOT NULL COMMENT '格局 三室一厅',
    floor VARCHAR(255) NOT NULL COMMENT '楼层',
    house_age VARCHAR(255) NOT NULL COMMENT '建筑年代(房龄)',
    uni_price VARCHAR(255) NOT NULL COMMENT '单价',
    area_by_China VARCHAR(255) NOT NULL COMMENT '地域 e.g. 东北 华北',
    `size` VARCHAR(255) NOT NULL COMMENT '大小 建筑面积xx平米',
    renovation_condition VARCHAR(255) NOT NULL COMMENT '装修状况  精装',
    local_area VARCHAR(255) NOT NULL COMMENT '小区',
    create_date TIMESTAMP NOT NULL COMMENT '该记录进表时间',
    PRIMARY KEY (house_code)
)  ENGINE=INNODB;

commit;
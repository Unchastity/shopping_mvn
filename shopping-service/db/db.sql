DROP DATABASE IF EXISTS shopping;
DROP TRIGGER IF EXISTS user_AFTER_INSERT;

CREATE DATABASE IF NOT EXISTS shopping;
USE shopping;

# 系统用户
CREATE TABLE admin_user (
  uid         INT          NOT NULL AUTO_INCREMENT
  COMMENT '系统用户ID',
  user_name   VARCHAR(255) NOT NULL,
  password    VARCHAR(255) NOT NULL,
  min_ventory INT          NOT NULL,
  PRIMARY KEY (uid)
);

CREATE TABLE category (
  cid            INT                     NOT NULL AUTO_INCREMENT
  COMMENT '一级类目ID',
  c_name         VARCHAR(255)            NOT NULL
  COMMENT '一级类目名',
  discount       DECIMAL(3, 2) DEFAULT 0 NOT NULL
  COMMENT '折扣',
  privilege_time DATETIME                NULL
  COMMENT '优惠时间',
  PRIMARY KEY (cid)
);

CREATE TABLE category_second (
  csid    INT          NOT NULL  AUTO_INCREMENT
  COMMENT '二级类目ID',
  cs_name VARCHAR(255) NOT NULL,
  cid     INT          NOT NULL
  COMMENT '二级类目外键，关联一级类目ID',
  PRIMARY KEY (csid),
  CONSTRAINT category_second_fk_category FOREIGN KEY (cid) REFERENCES category (cid) ON UPDATE CASCADE
);

CREATE TABLE product (
  pid        INT                    NOT NULL AUTO_INCREMENT
  COMMENT '商品ID',
  p_name     VARCHAR(255)           NOT NULL,
  mark_price DECIMAL(8, 2)          NOT NULL
  COMMENT '商品官方价格',
  shop_price DECIMAL(8, 2)          NOT NULL
  COMMENT '商品实际零售价格',
  inventory  INT                    NOT NULL
  COMMENT '商品存货清单',
  image      VARCHAR(255) COMMENT '商品图片',
  p_desc     VARCHAR(255) COMMENT '商品描述',
  is_hot     INT DEFAULT 0          NOT NULL
  COMMENT '是否是热销产品',
  p_date     DATETIME DEFAULT now() NOT NULL
  COMMENT '商品生产日期',
  csid       INT                    NOT NULL
  COMMENT '产品所属二级类目',
  PRIMARY KEY (pid),
  CONSTRAINT product_fk_category_second FOREIGN KEY (csid) REFERENCES category_second (csid)
);

CREATE TABLE user (
  uid       INT           NOT NULL AUTO_INCREMENT
  COMMENT '用户ID',
  user_name VARCHAR(255)  NOT NULL,
  password  VARCHAR(255)  NOT NULL,
  real_name VARCHAR(255)  NOT NULL,
  email     VARCHAR(255)           DEFAULT NULL,
  phone     VARCHAR(16)   NOT NULL,
  age       INT                    DEFAULT NULL,
  addr      VARCHAR(255)           DEFAULT NULL
  COMMENT '用户收货地址',
  status    INT DEFAULT 0 NOT NULL,
  code      VARCHAR(64)   NOT NULL,
  home_addr VARCHAR(255)           DEFAULT NULL
  COMMENT '用户家庭住址',
  PRIMARY KEY (uid)
);

CREATE TABLE orders (
  oid                 INT           NOT NULL AUTO_INCREMENT
  COMMENT '订单ID',
  buyer_addr          VARCHAR(255)           DEFAULT NULL
  COMMENT '订单送货地址',
  buyer_name          VARCHAR(255)           DEFAULT NULL
  COMMENT '订单买家姓名',
  order_time          DATETIME               DEFAULT NULL
  COMMENT '订单产生时间',
  phone               VARCHAR(16)            DEFAULT NULL
  COMMENT '买家联系号码',
  status              INT           NOT NULL
  COMMENT '订单状态',
  total               DECIMAL(8, 2) NOT NULL
  COMMENT '订单总价格',
  uid                 INT           NOT NULL
  COMMENT '买家ID',
  seller_addr         VARCHAR(255)           DEFAULT NULL,
  order_time_complete DATETIME               DEFAULT NULL
  COMMENT '订单完成时间',
  PRIMARY KEY (oid),
  CONSTRAINT order_fk_user FOREIGN KEY (uid) REFERENCES user (uid)
);

CREATE TABLE orders_item (
  item_id   INT           NOT NULL AUTO_INCREMENT
  COMMENT '订单详情ID',
  count     INT           NOT NULL,
  sub_total DECIMAL(8, 2) NOT NULL,
  oid       INT           NOT NULL,
  pid       INT           NOT NULL,
  PRIMARY KEY (item_id),
  CONSTRAINT orders_item_fk_product FOREIGN KEY (pid) REFERENCES product (pid),
  CONSTRAINT orders_item_fk_orders FOREIGN KEY (oid) REFERENCES orders (oid)
);

CREATE TABLE wallet (
  wid   INT                            NOT NULL AUTO_INCREMENT
  COMMENT '钱包ID',
  money DECIMAL(8, 2) DEFAULT 0        NOT NULL
  COMMENT '钱包余额',
  uid   INT UNIQUE                     NOT NULL
  COMMENT '用户ID',
  PRIMARY KEY (wid),
  CONSTRAINT wallet_fk_user FOREIGN KEY (uid) REFERENCES user (uid) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE packet (
  pid INT NOT NULL AUTO_INCREMENT
  COMMENT '卡包ID',
  uid INT NOT NULL
  COMMENT '客户编号',
  PRIMARY KEY (pid),
  UNIQUE KEY (uid),
  CONSTRAINT packet_fk_user FOREIGN KEY (uid) REFERENCES user (uid)
);

CREATE TABLE ticket (
  tid          INT           NOT NULL AUTO_INCREMENT
  COMMENT '优惠券ID',
  privilege    DECIMAL(8, 2) NOT NULL
  COMMENT '优惠价格',
  consume      DECIMAL(8, 2) NOT NULL
  COMMENT '满减金额',
  use_time_max DATETIME      NULL
  COMMENT '优惠券使用期限',
  cid          INT           NOT NULL
  COMMENT '优惠券所属类别编号',
  pid          INT           NOT NULL
  COMMENT '卡包编号',
  use_time     DATETIME               DEFAULT NULL
  COMMENT '用户使用时间',
  PRIMARY KEY (tid),
  CONSTRAINT ticket_fk_category FOREIGN KEY (cid) REFERENCES category (cid),
  CONSTRAINT ticket_fk_packet FOREIGN KEY (pid) REFERENCES packet (pid)
);

# 警告信息
CREATE TABLE warn (
  mid         INT NOT NULL,
  min_ventory INT NOT NULL,
  PRIMARY KEY (mid)
);

# 触发器，用户与钱包一一对应，当添加一个用户时，对应添加钱包
/*DELIMITER //
CREATE TRIGGER user_AFTER_INSERT
AFTER INSERT ON user
FOR EACH ROW
  INSERT INTO wallet (uid) VALUE (new.uid)
//
DELIMITER ;*/

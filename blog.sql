-- 创建库
CREATE
IF NOT EXISTS DATABASE blog CHARACTER SET UTF8;

-- 选择库
USE
blog;

-- 文章表
CREATE TABLE `article`
(
    `id`         INT          NOT NULL AUTO_INCREMENT COMMENT '文章主键',
    `createDate` TIMESTAMP    NOT NULL COMMENT '文章创建时间',
    `updateDate` TIMESTAMP COMMENT '文章修改时间',
    `title`      VARCHAR(100) NOT NULL COMMENT '文章标题',
    `text`       VARCHAR(500) NOT NULL COMMENT '文章文本内容',
    `content`    TEXT         NOT NULL COMMENT '文章内容（html）',
    `up`         INT          NOT NULL DEFAULT 0 COMMENT '文章点赞数',
    `read`       INT          NOT NULL DEFAULT 0 COMMENT '文章阅读数',
    `down`       INT          NOT NULL DEFAULT 0 COMMENT '文章差数',
    `status`     INT          NOT NULL COMMENT '文章状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT=1000
  DEFAULT CHARSET = utf8;

-- 附件表
CREATE TABLE `attachment`
(
    `id`          INT          NOT NULL AUTO_INCREMENT COMMENT '附件主键',
    `createDate`  TIMESTAMP    NOT NULL COMMENT '附件创建时间',
    `updateDate`  TIMESTAMP COMMENT '附件修改时间',
    `contentType` VARCHAR(100) NOT NULL COMMENT '附件类型',
    `file`        VARCHAR(300) NOT NULL COMMENT '存放附件文件路径',
    `aid`         INT COMMENT '关联文章id',
    `type`        VARCHAR(50)  NOT NULL COMMENT '附件类型（图片，视频，文本...）',
    `status`      INT          NOT NULL COMMENT '附件状态',
    PRIMARY KEY (`id`),
    FOREIGN KEY (aid) references article (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- （类别/标签）表
CREATE TABLE `type`
(
    `id`         INT         NOT NULL AUTO_INCREMENT COMMENT '类别主键',
    `createDate` TIMESTAMP   NOT NULL COMMENT '类别创建时间',
    `updateDate` TIMESTAMP COMMENT '类别修改时间',
    `name`       VARCHAR(50) NOT NULL COMMENT '类别名称',
    `type`       INT         NOT NULL COMMENT '标记是标签还是类别(1:类别，2：标签)',
    `status`     INT         NOT NULL COMMENT '类别状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
-- （类别/标签）和文章中间表
CREATE TABLE `articleType`
(
    `aid` INT NOT NULL COMMENT '文章主键',
    `tid` INT NOT NULL COMMENT '类别主键',
    PRIMARY KEY (aid, tid),
    FOREIGN KEY (aid) references article (id),
    FOREIGN KEY (aid) references type (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


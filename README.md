# User
mysql数据库的用户表
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

修改application.properties配置文件
spring.datasource.url=jdbc:mysql://ip:3306/库名?useSSL=false&useUnicode=true&characterEncoding=utf8
spring.datasource.username=username（你的用户名）
spring.datasource.password=password（你的密码）

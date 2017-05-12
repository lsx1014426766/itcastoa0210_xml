package cn.itcast0210.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * alter table user drop foreign key FK36EBCBF453CD3F
alter table user_post drop foreign key FK143B0C945110E009
alter table user_post drop foreign key FK143B0C94510E7A19
drop table if exists department
drop table if exists person
drop table if exists post
drop table if exists user
drop table if exists user_post
create table department (did bigint not null, dname varchar(20), description varchar(100), primary key (did)) type=InnoDB
create table person (id bigint not null, name varchar(20), primary key (id)) type=InnoDB
create table post (pid bigint not null, pname varchar(20), description varchar(100), primary key (pid)) type=InnoDB
create table user (uid bigint not null, username varchar(20), password varchar(20), email varchar(20), phone varchar(20), sex varchar(20), did bigint, primary key (uid)) type=InnoDB
create table user_post (pid bigint not null, uid bigint not null, primary key (uid, pid)) type=InnoDB
alter table user add index FK36EBCBF453CD3F (did), add constraint FK36EBCBF453CD3F foreign key (did) references department (did)
alter table user_post add index FK143B0C945110E009 (uid), add constraint FK143B0C945110E009 foreign key (uid) references user (uid)
alter table user_post add index FK143B0C94510E7A19 (pid), add constraint FK143B0C94510E7A19 foreign key (pid) references post (pid)

通过项目中的配置文件，生成表结构
 * @author lsx
 * @Description 
 *
 */
public class ExportDB {
	public static void main(String[] args) {
		//读取hibernate.cfg.xml文件
		//注意：默认查找路径为/hibernate.cfg.xml
		Configuration cfg = new Configuration().configure("/hibernate/hibernate.cfg.xml");
		///hibernate.cfg.xml not found
		//cfg.configure("/config/hibernate/hibernate.cfg.xml");
		//cfg.addResource("/config/hibernate/hibernate.cfg.xml");
		//cfg.addFile("config/hibernate/hibernate.cfg.xml");
		//hbm2ddl
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
		}
}

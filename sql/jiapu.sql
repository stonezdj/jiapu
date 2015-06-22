create database jiapu default charset=utf8;
use jiapu;
drop table applyrequest;
drop table article;
drop table family;
drop table jiapuMessage;
drop table jiapuactivity;
drop table jiapuuser;
drop table person;
drop table message;
drop table picture;
drop table useroperation;

create table person
(
	personid int(17) auto_increment primary key ,
	familyid int,
	parentid int,
	name  varchar(100),
	othername  varchar(100),
	sex  int,
	birth  date,
	death  date,
	marriage varchar(300),
	deeds varchar(300),
	misc varchar(200),
	tomblocation varchar(200)
	
) default charset=utf8;

create table jiapuuser
(
  username varchar(50) primary key,
  password varchar(256),
  email_address varchar(50),
  mobile_phone varchar(100),
  realname varchar(100),
  personid int,
  familyid int,
  isEnabled bit default 0,
  userrole varchar(100)
 ) default charset=utf8;

 create table family
 (
 	familyid int auto_increment primary key,
 	familyname varchar(100),
 	province varchar(100),
 	county varchar(100),
 	town varchar(100),
 	villege varchar(100),
 	smallvillege varchar(100),
 	username varchar(50),
 	createDate date
 ) default charset=utf8;

 create table applyrequest
 (
 	requestid int auto_increment primary key,
 	familyid int,
 	username varchar(50),
 	applydate date,
 	status int
 ) default charset=utf8;



  create table message
  (
  	messageid int auto_increment primary key,
  	familyid int,
  	userid varchar(100),
  	message varchar(500),
  	reply varchar(300),
  	senddate date  	
  ) default charset utf8;

  create table picture
 (
 	pictureid int  auto_increment primary key,
 	location varchar(300),
 	description varchar(200)
 ) default charset=utf8;
 
 create table useroperation
(
	operationid int auto_increment primary key ,
	username varchar(100),
	optype int,
	createDate date,
	code varchar(100)
) default charset=utf8;

create table article
(
	id int auto_increment primary key,
	familyid int,
	title varchar(100),
	content longtext,
	createDate date,
	username varchar(100),
	orderid int,
	category varchar(100),	
	visible int
) default charset=utf8;

create table jiapuMessage
(
	messageid int auto_increment primary key,
	createDate date,
	message varchar(512),
	senderid varchar(50),
	recieverid varchar(50)
)default charset=utf8;

create table jiapuactivity
(
	activityid int auto_increment primary key,
	recordDate date,
	startDate date,
	ownerid varchar(50),
	message varchar(512)
)default charset=utf8;

create table userfamily
(
	username varchar(100),
	familyid int,
	familyrole varchar(100),
	isdefault tinyint(1),
	primary key(username, familyid)
)default charset=utf8;
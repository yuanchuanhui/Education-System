create schema if not exists education collate utf8mb4_0900_ai_ci;

-- -----------------------------------
-- 删除所有表
SELECT
    CONCAT('drop table   ', table_name, ';')
FROM
    information_schema.`TABLES`
WHERE
    table_schema = 'aitest';

-- -----------------------------------

create table if not exists role
(
    roleId int auto_increment
        primary key,
    roleName varchar(50) not null,
    permission varchar(50) null,
    roleNameZh varchar(50) null
);

create table if not exists user
(
    username varchar(20) not null
        primary key,
    password varchar(20) not null,
    permission varchar(50) null,
    xflxdelsign tinyint(1) default 0 null
);

create table if not exists user_role
(
    username varchar(20) null,
    roleId int null,
    constraint user_role_role_roleId_fk
        foreign key (roleId) references role (roleId),
    constraint user_role_user_username_fk
        foreign key (username) references user (username)
);

create table if not exists school
(
    id int auto_increment
        primary key,
    schoolname varchar(100) null
);

create table if not exists class
(
    id int auto_increment
        primary key,
    classname varchar(20) null,
    year date null,
    school int null,

    constraint class_school_id_fk
        foreign key (school) references school (id)
);


DROP TABLE IF	EXISTS student;
CREATE TABLE student (
	stuid INT NOT NULL,
	stuname VARCHAR ( 20 ) NOT NULL,
	stusex tinyint ( 1 ),
	birth date,
	stuschool int,
	stuclass int,
	stuss VARCHAR ( 50 ),
	stujg VARCHAR ( 500 ),
	stuzzmm VARCHAR ( 50 ),
	studelsign TINYINT(1),
	
	PRIMARY KEY (stuid ),
	FOREIGN KEY (stuschool) REFERENCES school(id),
	FOREIGN KEY (stuclass) REFERENCES class(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF	EXISTS xiaofeileixing;
CREATE TABLE xiaofeileixing (
	xflxid INT NOT NULL,
	xflxname VARCHAR ( 50 ) NOT NULL,
	xflxdelsign TINYINT(1),
	
	PRIMARY KEY (xflxid ) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS tushu;
CREATE TABLE tushu(
	isbn INT NOT NULL,
	tsname VARCHAR(50) NOT NULL,
	tssort VARCHAR(50),
	tsauthor VARCHAR(50),
	tskc INT NOT NULL,
	tsdelsign TINYINT(1),
	PRIMARY KEY (isbn ) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS jieshu;
CREATE TABLE jieshu(
	stuid INT ,
	isbn INT ,
	jydate date ,
	jsyhdate date,
	jsghdate date ,
	jscqdays INT,
	jsfine float ,
	jssort int,
	jsdelsign TINYINT(1),
	PRIMARY KEY (stuid,isbn,jydate ) ,
	FOREIGN KEY (stuid) REFERENCES student(stuid),
	FOREIGN key (isbn) REFERENCES tushu(isbn)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS xiaofei;
CREATE TABLE xiaofei(
	stuid INT ,
	xflxid INT ,
	xfid INT,
	xftime date,
	xfaddress VARCHAR(50),
	xfmoney float ,
	xfdelsign TINYINT(1),
	PRIMARY KEY (xfid) ,
	FOREIGN KEY (stuid) REFERENCES student(stuid),
	FOREIGN key (xflxid) REFERENCES xiaofeileixing(xflxid)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS ceshi;
CREATE TABLE ceshi(
	csid INT ,
	cstime date ,
	
	PRIMARY KEY (csid ) 
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS xinliceshiti;
CREATE TABLE xinliceshiti(
	xlcstmh INT ,
	csid INT ,
	xlcsdescription VARCHAR(500),
	xlcsdscore int ,
	xlcscscore int,
	xlcsbscore int,
	xlcsascore int,
	xlcsdelsign TINYINT(1),
	PRIMARY KEY (xlcstmh ) ,
	FOREIGN KEY (csid) REFERENCES ceshi(csid)
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS menjin;
CREATE TABLE menjin(
	mjid INT ,
	stuid INT ,
	mjtime date ,
	mjadress VARCHAR(50),
	
	PRIMARY KEY (mjid ) ,
	FOREIGN KEY (stuid) REFERENCES student(stuid)
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS yujing;
CREATE TABLE yujing(
	stuid INT ,
	yjsort VARCHAR(50) CHECK (yjsort IN('社交预警','心理预警','挂科预警','毕业预警')),
	yjtime date ,
	yjjibie VARCHAR(20),
	
	PRIMARY KEY (stuid,yjsort ) ,
	FOREIGN KEY (stuid) REFERENCES student(stuid)
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher(
	tid INT ,
	tname VARCHAR(20) ,
	tsex VARCHAR(20) ,
	tpost VARCHAR(20),
	
	PRIMARY KEY (tid ) 
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS course;
CREATE TABLE course(
	cid INT,
	cname	VARCHAR(20),
	csort VARCHAR(20),
	tid INT,
	cdelsign VARCHAR(20),
	
	PRIMARY KEY (cid ,tid) ,
	FOREIGN KEY (tid) REFERENCES teacher(tid)
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS grade;
CREATE TABLE grade(
	cid INT ,
	stuid INT ,
	gterm date,
	score int,
	isfail TINYINT(1),
	gdelsign TINYINT(1),
	
	PRIMARY KEY (cid,stuid ) ,
	FOREIGN KEY (stuid) REFERENCES student(stuid),
	FOREIGN KEY (cid) REFERENCES course(cid)
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS xinlitest;
CREATE TABLE xinlitest(
	csid INT ,
	stuid INT ,
	selection varchar(10),
	
	PRIMARY KEY (csid,stuid ) ,
	FOREIGN KEY (stuid) REFERENCES student(stuid),
	FOREIGN KEY (csid) REFERENCES ceshi(csid)
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS zhuanyeactivity;
CREATE TABLE zhuanyeactivity(
	aid INT ,
	aname VARCHAR(20) ,
	ajibie VARCHAR(20),
	asort VARCHAR(20),
	adelsign TINYINT(1),
	
	
	PRIMARY KEY (aid )
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS award;
CREATE TABLE award(
	stuid INT ,
	arongyu VARCHAR(500),
	asort VARCHAR(20),
	atime date,
	adelsign TINYINT(1),
	

	FOREIGN KEY (stuid) REFERENCES student(stuid)
	
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS internetapplication;
CREATE TABLE internetapplication(
	iaid INT ,
	iayuming VARCHAR(20) ,
	iasort VARCHAR(20),
	iadelsign TINYINT(1),
	
	PRIMARY KEY (iaid )
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS internetdata;
CREATE TABLE internetdata(
	iaid INT ,
	stuid INT,
	idstarttime datetime,
	idendtime datetime,
	iddelsign TINYINT(1),
	
	PRIMARY KEY (iaid,stuid,idstarttime ),
	FOREIGN KEY(stuid)REFERENCES student(stuid),
	FOREIGN KEY (iaid)REFERENCES internetapplication(iaid)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS groupdata;
CREATE TABLE groupdata(
	gdid VARCHAR(20),
	gdsex VARCHAR(20),
	gdage VARCHAR(20),
	gdzzmm VARCHAR(20),
	gdmz VARCHAR(20),
	gdsyd VARCHAR(20),
	
	PRIMARY KEY (gdid)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS groupbehavior;
CREATE TABLE groupbehavior(
	gdid VARCHAR(20),
	gbmonth  VARCHAR(10),
	gbxws VARCHAR(10),
	gbzftime time,
	gbsjtime time,
	gbsstime VARCHAR(20),
	
	PRIMARY KEY (gdid),
	FOREIGN KEY (gdid) REFERENCES groupdata(gdid)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- -----------------------------------
DROP TABLE IF EXISTS groupconsumption;
CREATE TABLE groupconsumption(
	gdid VARCHAR(20),
	gcmonth  VARCHAR(10),
	gcxfbili VARCHAR(10),
	gcavexf VARCHAR(10),
	
	PRIMARY KEY (gdid),
	FOREIGN KEY (gdid) REFERENCES groupdata(gdid)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS grouplibrary;
CREATE TABLE grouplibrary(
	gdid VARCHAR(20),
	glmonth  VARCHAR(10),
	glavejy VARCHAR(10),
	glavesc VARCHAR(10),
	
	PRIMARY KEY (gdid),
	FOREIGN KEY (gdid) REFERENCES groupdata(gdid)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS groupstudy;
CREATE TABLE groupstudy(
	gdid VARCHAR(20),
	gsxueqi  VARCHAR(10),
	gsfailcount INT,
	
	gsfailbili VARCHAR(10),
	
	PRIMARY KEY (gdid),
	FOREIGN KEY (gdid) REFERENCES groupdata(gdid)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;
-- -----------------------------------
DROP TABLE IF EXISTS social;
CREATE TABLE social(
	stuid INT,
	fristuid INT,
	
	FOREIGN KEY (stuid) REFERENCES student(stuid),
	FOREIGN KEY (fristuid) REFERENCES student(stuid)
	
) ENGINE=INNODB DEFAULT CHARSET=utf8;

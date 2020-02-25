create schema if not exists education collate utf8mb4_0900_ai_ci;

use education;

create table if not exists ceshi
(
	csid int not null
		primary key,
	cstime date null
)
charset=utf8;

create table if not exists internetapplication
(
	iaid int not null
		primary key,
	iayuming varchar(20) null,
	iasort varchar(20) null,
	iadelsign tinyint(1) default 0 null
)
charset=utf8;

create table if not exists role
(
	roleId int auto_increment
		primary key,
	roleName varchar(50) not null,
	permission varchar(50) null,
	roleNameZh varchar(50) null
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

create table if not exists student
(
	stuid int not null
		primary key,
	stuname varchar(20) not null,
	stusex tinyint(1) null,
	birth date null,
	stuschool int null,
	stuclass int null,
	stuss varchar(50) null,
	stujg varchar(500) null,
	stuzzmm varchar(50) null,
	studelsign tinyint(1) default 0 null,
	constraint student_ibfk_1
		foreign key (stuschool) references school (id),
	constraint student_ibfk_2
		foreign key (stuclass) references class (id)
)
charset=utf8;

create table if not exists award
(
	stuid int null,
	arongyu varchar(500) null,
	asort varchar(20) null,
	atime date null,
	adelsign tinyint(1) default 0 null,
	constraint award_ibfk_1
		foreign key (stuid) references student (stuid)
)
charset=utf8;

create index stuid
	on award (stuid);

create table if not exists internetdata
(
	iaid int not null,
	stuid int not null,
	idstarttime datetime not null,
	idendtime datetime null,
	iddelsign tinyint(1) default 0 null,
	primary key (iaid, stuid, idstarttime),
	constraint internetdata_ibfk_1
		foreign key (stuid) references student (stuid),
	constraint internetdata_ibfk_2
		foreign key (iaid) references internetapplication (iaid)
)
charset=utf8;

create index stuid
	on internetdata (stuid);

create table if not exists menjin
(
	mjid int not null
		primary key,
	stuid int null,
	mjtime datetime null,
	mjadress varchar(100) null,
	constraint menjin_ibfk_1
		foreign key (stuid) references student (stuid)
)
charset=utf8;

create index stuid
	on menjin (stuid);

create table if not exists social
(
	stuid int null,
	fristuid int null,
	constraint social_ibfk_1
		foreign key (stuid) references student (stuid),
	constraint social_ibfk_2
		foreign key (fristuid) references student (stuid)
)
charset=utf8;

create index fristuid
	on social (fristuid);

create index stuid
	on social (stuid);

create index stuclass
	on student (stuclass);

create index stuschool
	on student (stuschool);

create table if not exists teacher
(
	tid int not null
		primary key,
	tname varchar(20) null,
	tsex tinyint(1) null,
	tpost varchar(20) null
)
charset=utf8;

create table if not exists course
(
	cid int not null,
	cname varchar(20) null,
	csort varchar(20) null,
	tid int not null,
	cdelsign tinyint(1) default 0 null,
	primary key (cid, tid),
	constraint course_ibfk_1
		foreign key (tid) references teacher (tid)
)
charset=utf8;

create index tid
	on course (tid);

create table if not exists grade
(
	cid int not null,
	stuid int not null,
	gterm date null,
	score int null,
	isfail tinyint(1) null,
	gdelsign tinyint(1) default 0 null,
	primary key (cid, stuid),
	constraint grade_ibfk_1
		foreign key (stuid) references student (stuid),
	constraint grade_ibfk_2
		foreign key (cid) references course (cid)
)
charset=utf8;

create index stuid
	on grade (stuid);

create table if not exists tushu
(
	isbn varchar(50) not null
		primary key,
	tsname varchar(50) not null,
	tssort varchar(50) null,
	tsauthor varchar(50) null,
	tskc int not null,
	tsdelsign tinyint(1) default 0 null
)
charset=utf8;

create table if not exists jieshu
(
	stuid int not null,
	isbn varchar(50) not null,
	jydate date not null,
	jsyhdate date null,
	jsghdate date null,
	jscqdays int null,
	jsfine float null,
	jssort int null,
	jsdelsign tinyint(1) default 0 null,
	primary key (stuid, isbn, jydate),
	constraint jieshu_ibfk_1
		foreign key (stuid) references student (stuid),
	constraint jieshu_tushu_isbn_fk
		foreign key (isbn) references tushu (isbn)
)
charset=utf8;

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

create table if not exists xiaofeileixing
(
	xflxid int not null
		primary key,
	xflxname varchar(50) not null,
	xflxdelsign tinyint(1) default 0 null
)
charset=utf8;

create table if not exists xiaofei
(
	stuid int null,
	xflxid int null,
	xfid int not null
		primary key,
	xftime date null,
	xfaddress varchar(50) null,
	xfmoney float null,
	xfdelsign tinyint(1) default 0 null,
	constraint xiaofei_ibfk_1
		foreign key (stuid) references student (stuid),
	constraint xiaofei_ibfk_2
		foreign key (xflxid) references xiaofeileixing (xflxid)
)
charset=utf8;

create index stuid
	on xiaofei (stuid);

create index xflxid
	on xiaofei (xflxid);

create table if not exists xinliceshiti
(
	xlcstmh int not null
		primary key,
	csid int null,
	xlcsdescription varchar(500) null,
	xlcsdscore int null,
	xlcscscore int null,
	xlcsbscore int null,
	xlcsascore int null,
	xlcsdelsign tinyint(1) default 0 null,
	constraint xinliceshiti_ibfk_1
		foreign key (csid) references ceshi (csid)
)
charset=utf8;

create index csid
	on xinliceshiti (csid);

create table if not exists xinlitest
(
	csid int not null,
	stuid int not null,
	primary key (csid, stuid),
	constraint xinlitest_ibfk_1
		foreign key (stuid) references student (stuid),
	constraint xinlitest_ibfk_2
		foreign key (csid) references ceshi (csid)
)
charset=utf8;

create index stuid
	on xinlitest (stuid);

create table if not exists yujing
(
	stuid int not null,
	yjsort varchar(50) not null,
	yjtime date null,
	yjjibie varchar(20) null,
	primary key (stuid, yjsort),
	constraint yujing_ibfk_1
		foreign key (stuid) references student (stuid)
)
charset=utf8;

create table if not exists zhuanyeactivity
(
	aid int not null
		primary key,
	aname varchar(20) null,
	ajibie int null,
	asort varchar(20) null,
	adelsign tinyint(1) default 0 null
)
charset=utf8;



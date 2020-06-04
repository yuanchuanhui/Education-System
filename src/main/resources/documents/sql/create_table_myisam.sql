create schema if not exists education collate utf8mb4_0900_ai_ci;
use education;

create table if not exists ceshi
(
	csid int not null
		primary key,
	cstime date null
)engine = MyISAM
charset=utf8;

create table if not exists course
(
	cid varchar(100) not null,
	cname varchar(200) not null,
	csort varchar(20) null,
	tid int null,
	cdelsign tinyint(1) default 0 null,
	primary key (cid, cname)
)engine = MyISAM
charset=utf8;

create table if not exists internetapplication
(
	iaid int not null
		primary key,
	iayuming varchar(20) null,
	iasort varchar(20) null,
	iadelsign tinyint(1) default 0 null
)engine = MyISAM
charset=utf8;

create table if not exists role
(
	roleId int auto_increment
		primary key,
	roleName varchar(50) not null,
	permission varchar(50) null,
	roleNameZh varchar(50) null
)
charset=utf8;

create table if not exists school
(
	id int auto_increment
		primary key,
	schoolname varchar(100) null
)engine = MyISAM
charset=utf8;

create table if not exists class
(
	classname varchar(20) not null,
	intyear int null,
	school int null,
	constraint class_classname_uindex
		unique (classname),
	constraint class_school_id_fk
		foreign key (school) references school (id)
)engine = MyISAM
charset=utf8;

create index class_intyear_index
	on class (intyear);

alter table class
	add primary key (classname);

create table if not exists student
(
	stuid int auto_increment
		primary key,
	stuname varchar(20) not null,
	stusex tinyint(1) null,
	birth date null,
	stuschool int null,
	stuclass varchar(20) null,
	stuss varchar(50) null,
	stujg varchar(500) null,
	stuzzmm varchar(50) null,
	studelsign tinyint(1) default 0 null,
	constraint student_class_classname_fk
		foreign key (stuclass) references class (classname),
	constraint student_ibfk_1
		foreign key (stuschool) references school (id)
)engine = MyISAM
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
)engine = MyISAM
charset=utf8;

create index stuid
	on award (stuid);

create table if not exists grade
(
	cid varchar(100) not null,
	stuid int not null,
	gterm int null,
	gtime date null,
	score int null,
	credit float null,
	course_type int null,
	isfail int null,
	gdelsign tinyint(1) default 0 null,
	primary key (stuid, cid),
	constraint grade_course_cid_fk
		foreign key (cid) references course (cid),
	constraint grade_ibfk_1
		foreign key (stuid) references student (stuid)
)engine = MyISAM
charset=utf8;

create index grade_gterm_index
	on grade (gterm);

create index stuid
	on grade (stuid);

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
)engine = MyISAM
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
)engine = MyISAM
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
)engine = MyISAM
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
)engine = MyISAM
charset=utf8;

create table if not exists tushu
(
	tsid varchar(50) not null
		primary key,
	isbn varchar(50) null,
	tsname varchar(1000) null,
	tssort varchar(10) null,
	tsauthor varchar(500) null,
	tskc int null,
	tsdelsign tinyint(1) default 0 null
)engine = MyISAM
charset=utf8;

create table if not exists jieshu
(
	stuid int not null,
	tsid varchar(50) not null,
	jydate date not null,
	jsyhdate date null,
	jsghdate date null,
	jscqdays int null,
	jsfine float null,
	jssort int null,
	jsdelsign tinyint(1) default 0 null,
	primary key (stuid, tsid, jydate),
	constraint jieshu_ibfk_1
		foreign key (stuid) references student (stuid),
	constraint jieshu_tushu_tsid_fk
		foreign key (tsid) references tushu (tsid)
)engine = MyISAM
charset=utf8;

create table if not exists user
(
	username varchar(20) not null
		primary key,
	password varchar(20) not null,
	permission varchar(50) null,
	xflxdelsign tinyint(1) default 0 null
)
charset=utf8;

create table if not exists user_role
(
	username varchar(20) null,
	roleId int null,
	constraint user_role_role_roleId_fk
		foreign key (roleId) references role (roleId),
	constraint user_role_user_username_fk
		foreign key (username) references user (username)
)
charset=utf8;

create table if not exists xiaofei
(
	xfid int auto_increment
		primary key,
	stuid int null,
	xflxname varchar(50) null,
	xftime datetime null,
	xfaddress varchar(50) null,
	xfmoney float null,
	xfdelsign tinyint(1) default 0 null,
	constraint xiaofei_ibfk_1
		foreign key (stuid) references student (stuid)
)engine = MyISAM
charset=utf8;

create index xiaofei_xftime_index
	on xiaofei (xftime);

create table if not exists xiaofeileixing
(
	xflxid int auto_increment
		primary key,
	xflxname varchar(50) not null,
	xflxdelsign tinyint(1) default 0 null,
	constraint xiaofeileixing_xflxname_uindex
		unique (xflxname)
)engine = MyISAM
charset=utf8;

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
)engine = MyISAM
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
)engine = MyISAM
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
)engine = MyISAM
charset=utf8;

create table if not exists zhuanyeactivity
(
	aid int not null
		primary key,
	aname varchar(20) null,
	ajibie int null,
	asort varchar(20) null,
	adelsign tinyint(1) default 0 null
)engine = MyISAM
charset=utf8;


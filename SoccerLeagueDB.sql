create table League (
    lid integer primary key,
    lyear integer not null,
    season varchar(10) not null,
    title varchar(30) not null
) engine = InnoDB charset = utf8;

alter table League modify lid int auto_increment;

create table Player(
    pid integer primary key auto_increment,
    name varchar(30) not null,
    address varchar(30) not null,
    city varchar(20) not null,
    email varchar(40) not null
) engine = InnoDB charset = utf8;

create table Registration(
    rid integer primary key auto_increment,
    division varchar(20) not null,
    LEAGUE_LID integer not null,
    PLAYER_PID integer not null
) engine = InnoDB charset = utf8;

create table AdminUser(
    uid integer primary key,
    username varchar(20) not null,
    password varchar(20) not null
) engine = InnoDB charset = utf8;

insert into League(lid, lyear, season, title) values(1, 2008, 'Spring', 'Soccer League (Spring "08)');

insert into League(lid, lyear, season, title) values(2, 2008, 'Summer', 'Summer Soccer Fest 2008');

insert into League(lid, lyear, season, title) values(3, 2008, 'Fall', 'Fall Soccer League  (2008)');

insert into League(lid, lyear, season, title) values(4, 2009, 'Spring', 'Soccer League (Spring "09)');

insert into League(lid, lyear, season, title) values(5, 2009, 'Summer', 'The Summer of Soccer Love 2009');

insert into League(lid, lyear, season, title) values(6, 2009, 'Fall', 'Fall Soccer League (2009)');

insert into AdminUser(uid, username, password) values(100, 'admin', 'admin');

insert into AdminUser(uid, username, password) values(101, 'jack', 'admin');

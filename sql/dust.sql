drop table dust_member;
CREATE TABLE dust_member
(
    id        varchar(20),
    pw        varchar(20) NOT null,
    addr      varchar(50),
    age       int(3),
    phone_num varchar(13) NOT null,
    gender    varchar(6),
    email     varchar(20) NOT null,
    nickname  varchar(10) NOT null,
    LEVEL     varchar(10) NOT NULL,
    CONSTRAINT pk_MEMBER_id
        PRIMARY KEY (id)
);

drop table dust_comment;
CREATE TABLE dust_comment
(
    comment_num int(10) auto_increment,
    id          varchar(20),
    content     varchar(500) NOT NULL,
    LIKE_it     int (10),
    written_date datetime default current_timestamp,
    board_no     int(10),
    CONSTRAINT pk_comment_num
        PRIMARY KEY (comment_num),
    foreign key (id) references dust_member (id) on UPDATE cascade,
    foreign key (board_no) references dust_board (board_no) on delete cascade
);

drop table dust_board;
CREATE TABLE dust_board
(
    board_no     int(10) auto_increment,
    title        varchar(30)            NOT NULL,
    content      varchar(500)           NOT NULL,
    view_count   int(10)                NOT NULL,
    id     varchar(20),
    written_date datetime default current_timestamp,
    distinguish int(1) not null,
    category varchar(30) not null,
    CONSTRAINT pk_board_no
        PRIMARY KEY (board_no),
    foreign key (id) references dust_member (id) on UPDATE cascade
);

select * from dust_member;
select * from dust_board;
select * from dust_comment;

UPDATE dust_member SET id = 'test1' where age=20;

insert into dust_member
(id, pw,addr ,age, phone_num,gender, email, nickname, level)
values ('test2', '2222','사상', 20, '01000000000','M', 'test2@dust.net', 'test2', 'dust');

insert into dust_board
(title, content, view_count, id,distinguish,category)
values ('test2title2', 'test2content2', 0, 'test2',0,'HORROR');

insert into dust_comment
(id,content,LIKE_it,board_no )
values('test1','tes1댓글',0,2);

insert into dust_comment
(id,content,LIKE_it,board_no )
values('test2','tes2댓글',0,4);



UPDATE dust_member
SET addr ='부산', gender='F'
where id='test1';







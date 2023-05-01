drop table dust_member;
CREATE TABLE dust_member
(
    id        varchar(20),
    pw        varchar(20) NOT null,
    addr      varchar(50) NOT null,
    age       int(3)      NOT null,
    phone_num varchar(13) NOT null,
    gender    varchar(6)  NOT null,
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
    content     varchar(50) NOT NULL,
    LIKE_it     int (10),
    CONSTRAINT pk_comment_num
        PRIMARY KEY (comment_num),
    foreign key (id) references dust_member (id)
);

drop table dust_board;
CREATE TABLE dust_board
(
    board_no     int(10) auto_increment,
    title        varchar(30)            NOT NULL,
    content      varchar(500)           NOT NULL,
    view_count   int(10)                NOT NULL,
    id     varchar(20),
    comment_num  int(10),
    written_date TIMESTAMP,
    CONSTRAINT pk_board_no
        PRIMARY KEY (board_no),
    foreign key (id) references dust_member (id),
    foreign key (comment_num) references dust_comment (comment_num)
);

select * from dust_member;
select * from dust_board;
select * from dust_comment;
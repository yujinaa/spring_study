create table reply(
id varchar(20) not null,--id는 비어있음 안되기에 꼭 적는다
title varchar(50)not null,--제목도 비어있음 안되기에 꼭 적는다
content varchar(300),
write_group number(10) not null,
write_date date default sysdate,
constraint fk_test1 foreign key(write_group) references mvc_board(write_no) on delete cascade,  --몇번 게시글에 대한 답인지 같은 게시글번호를 그룹으로 묶기
constraint fk_test2 foreign key(id) references membership(id) on delete cascade
);
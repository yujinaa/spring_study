create table mvc_board(
Write_no number(10) primary key, --글번호
Title varchar2(100),                      --제목
Content varchar2(300),               --내용
Savedate date default sysdate,     --글쓴날짜
Hit number(10) default 0,           --조회수
Image_file_name varchar(100),  --이미지
Id varchar(20) not null,              --작성자(로그인한 사용자)
constraint fk_test foreign key(id) references membership(id) on delete cascade  --references membership : foreign과 id로 참조된다. 부모가 된다(여기선 membership)
); --constraint:제약조건을 건다. fk_test foreign: 설정 이름                                    --foreign key : 연결되는 참조키. 자식이라고 보면 된다(여기선 mvc_board)
create sequence mvc_board_seq;
create table system_info(
system_num number(5),
constraint test_name check(system_num<=5) --5보다 작거나 같은것만 넣기(제약조건)
);
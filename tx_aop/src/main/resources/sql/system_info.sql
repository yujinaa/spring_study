create table system_info(
system_num number(5),
constraint test_name check(system_num<=5)
);